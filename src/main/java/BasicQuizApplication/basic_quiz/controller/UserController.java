package BasicQuizApplication.basic_quiz.controller;

import BasicQuizApplication.basic_quiz.domain.Education;
import BasicQuizApplication.basic_quiz.domain.User;
import BasicQuizApplication.basic_quiz.service.EducationService;
import BasicQuizApplication.basic_quiz.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }


    @PostMapping("")
    public ResponseEntity createUser(@RequestBody @Valid User user) {
        // GTB: - 通过自定义 annotation 来实现比较好
        if(user.getName().getBytes().length < 1 || user.getName().getBytes().length > 128) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "输入用户名不符合规范");
        }else if(user.getAvatar().getBytes().length < 8 || user.getAvatar().getBytes().length > 512) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "输入Avatar不符合规范");
        }else if(user.getDescription().getBytes().length > 1024) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "输入Description不符合规范");
        }
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
