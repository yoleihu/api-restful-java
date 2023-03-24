package challenge.java.api.controller;

import challenge.java.api.dto.AuthenticationData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity logon(@RequestBody @Valid AuthenticationData data){
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
