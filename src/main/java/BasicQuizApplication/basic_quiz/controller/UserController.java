package BasicQuizApplication.basic_quiz.controller;

import BasicQuizApplication.basic_quiz.domain.User;
import BasicQuizApplication.basic_quiz.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        System.out.println(id);
        return userService.getUser(id);
    }

}
