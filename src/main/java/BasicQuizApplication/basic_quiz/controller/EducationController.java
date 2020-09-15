package BasicQuizApplication.basic_quiz.controller;

import BasicQuizApplication.basic_quiz.domain.Education;
import BasicQuizApplication.basic_quiz.service.EducationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class EducationController {

    final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/{id}/educations")
    public ResponseEntity<List<Education>> getUserEducations(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(educationService.getUserEducation(id));
    }
    @PostMapping("/{id}/educations")
    public ResponseEntity addUserEducation(@PathVariable Long id, @RequestBody @Valid Education education) {
        if(education.getTitle().getBytes().length < 1 || education.getTitle().getBytes().length > 256) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "输入Title不符合规范");
        }else if(education.getDescription().getBytes().length < 1 || education.getDescription().getBytes().length > 4096) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "输入Description不符合规范");
        }
        educationService.addEducation(id, education);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
