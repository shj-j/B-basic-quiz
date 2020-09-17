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
        User user = userRepository.findById(id);
        // GTB: - 这种类似的地方都可以不要 else，代码里有好几处这样的地方
        if (user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "用户不存在");
        }else {
            return user;
        }
    }

    public void createUser(User user) {
        User existUser = userRepository.findById(user.getId());
        // GTB: - 功能角度来讲，不存在用户已存在的错误，name 是可以重复的
        if( existUser != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "用户已存在");
        }else {
            userRepository.save(user);
        }
    }
}
