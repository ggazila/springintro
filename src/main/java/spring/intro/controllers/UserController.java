package spring.intro.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.dto.UserResponseDto;
import spring.intro.models.User;
import spring.intro.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        User user = userService.get(id);
        return getUserResponseDto(user);
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(this::getUserResponseDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/inject", method = RequestMethod.GET)
    public String addUsersToDB() {
        for (int i = 1; i <= 4; i++) {
            userService.add(new User("user" + i, "pass" + i));
        }
        return "Good!";
    }

    private UserResponseDto getUserResponseDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
