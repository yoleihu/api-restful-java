package challenge.java.api.mapper;

import challenge.java.api.dto.UserDto;
import challenge.java.api.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getLogin(), user.getPassword());
    }

    public static User toEntity(UserDto userDto) {
        return new User(userDto.id(), userDto.login(), userDto.password());
    }

    public static List<UserDto> toDtoList(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = toDto(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }
}
