package challenge.java.api.controller;


import challenge.java.api.dto.UserDto;
import challenge.java.api.dto.AuthenticationData;
import challenge.java.api.mapper.UserMapper;
import challenge.java.api.model.User;
import challenge.java.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationData data) {
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = authenticationManager.authenticate(token);
        // Lógica para gerar e retornar o token JWT
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Realiza o upload de arquivos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Criação realizada com sucesso"),
    })
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        User createdUser = userService.createUser(user);
        UserDto createdUserDto = UserMapper.toDto(createdUser);
        return ResponseEntity.ok(createdUserDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        User updatedUser = userService.updateUser(id, user);
        UserDto updatedUserDto = UserMapper.toDto(updatedUser);
        return ResponseEntity.ok(updatedUserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        UserDto userDto = UserMapper.toDto(user);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDto> userDtos = UserMapper.toDtoList(users);
        return ResponseEntity.ok(userDtos);
    }
}
