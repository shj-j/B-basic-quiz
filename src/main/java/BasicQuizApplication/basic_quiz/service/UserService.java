package BasicQuizApplication.basic_quiz.service;

import BasicQuizApplication.basic_quiz.domain.User;
import BasicQuizApplication.basic_quiz.exception.UserNotFoundException;
import BasicQuizApplication.basic_quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(Long id) {
        User user = userRepository.findById(id);
        if (user == null){
            throw new UserNotFoundException("请求的资源不存在。");
        }else {
            return user;
        }
    }
}
