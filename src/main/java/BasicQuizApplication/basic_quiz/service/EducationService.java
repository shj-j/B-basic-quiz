package BasicQuizApplication.basic_quiz.service;

import BasicQuizApplication.basic_quiz.domain.Education;
import BasicQuizApplication.basic_quiz.domain.User;
import BasicQuizApplication.basic_quiz.exception.UserNotFoundException;
import BasicQuizApplication.basic_quiz.repository.EducationRepository;
import BasicQuizApplication.basic_quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
           throw new UserNotFoundException("请求的资源不存在。");
        }else {
            return educationList;
        }
    }
}
