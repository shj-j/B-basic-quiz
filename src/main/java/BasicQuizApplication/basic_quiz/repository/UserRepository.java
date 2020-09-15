package BasicQuizApplication.basic_quiz.repository;

import BasicQuizApplication.basic_quiz.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> userList = new ArrayList<>();

    {
        userList.add(User.builder()
                .id((long) 1)
                .name("KAMIL")
                .age((long) 24)
                .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut fuga aliquam ad asperiores voluptatem dolorum! Quasi.")
                .build());
    }

    public User findById(Long id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
    public List<User> findAll() {
        return userList;
    }
}
