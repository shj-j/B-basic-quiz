package BasicQuizApplication.basic_quiz.service;

import BasicQuizApplication.basic_quiz.domain.User;
import BasicQuizApplication.basic_quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "用户不存在"));
    }

    public void createUser(User user) {
        userRepository.save(user);
    }
}
