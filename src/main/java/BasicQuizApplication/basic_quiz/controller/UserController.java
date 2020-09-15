package BasicQuizApplication.basic_quiz.controller;

import BasicQuizApplication.basic_quiz.domain.Education;
import BasicQuizApplication.basic_quiz.domain.User;
import BasicQuizApplication.basic_quiz.service.EducationService;
import BasicQuizApplication.basic_quiz.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    final UserService userService;
    final EducationService educationService;

    public UserController(UserService userService, EducationService educationService) {
        this.userService = userService;
        this.educationService = educationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }

    @GetMapping("/{id}/educations")
    public ResponseEntity<List<Education>> getUserEducations(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(educationService.getUserEducation(id));
    }

}
