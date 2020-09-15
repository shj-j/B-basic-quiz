package BasicQuizApplication.basic_quiz.service;

import BasicQuizApplication.basic_quiz.domain.Education;
import BasicQuizApplication.basic_quiz.domain.User;
import BasicQuizApplication.basic_quiz.repository.EducationRepository;
import BasicQuizApplication.basic_quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EducationService {

    @Autowired
    EducationRepository educationRepository;
    @Autowired
    UserRepository userRepository;

    public List<Education> getUserEducation(Long id) {
        User user = userRepository.findById(id);
        List<Education> educationList = educationRepository.findByUserId(id);
        if ( user == null  ){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "用户不存在");
        }else {
            return educationList;
        }
    }

    public void addEducation(Long id, Education education) {
        User user = userRepository.findById(id);
        if ( user == null  ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "用户已存在");
        }
        educationRepository.save(id, education);
    }
}
