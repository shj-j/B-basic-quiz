package BasicQuizApplication.basic_quiz.controller;

import BasicQuizApplication.basic_quiz.domain.User;
import BasicQuizApplication.basic_quiz.repository.EducationRepository;
import BasicQuizApplication.basic_quiz.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;
    @Autowired
    EducationRepository educationRepository;

    @Test
    void should_get_user() throws Exception {
        mockMvc.perform(get("/users/0"))
                .andExpect(jsonPath("$.name").value("KAMIL"))
                .andExpect(status().isOk());
    }

    @Test
    void should_get_user_educations() throws Exception {
        mockMvc.perform(get("/users/1/educations"))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].year").value(2005))
                .andExpect(status().isOk());
    }
    @Test
    void should_create_user_if_user_not_exist() throws Exception {
        User user = User.builder()
                .id((long) 2)
                .name("KAMIL2")
                .age((long) 22)
                .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut fuga aliquam ad asperiores voluptatem dolorum! Quasi.")
                .build();
        String data = new ObjectMapper().writeValueAsString(user);

        mockMvc.perform(post("/users")
                .content(data)
                .contentType("application/json;charset=UTF-8")
                .characterEncoding("UTF-8"))
                .andExpect(status().isCreated());
    }

    @Test
    void should_not_create_user_if_user_exist() throws Exception {
        User user = User.builder()
                .id((long) 1)
                .name("KAMIL")
                .age((long) 24)
                .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut fuga aliquam ad asperiores voluptatem dolorum! Quasi.")
                .build();
        String data = new ObjectMapper().writeValueAsString(user);

        mockMvc.perform(post("/users")
                .content(data)
                .contentType("application/json;charset=UTF-8")
                .characterEncoding("UTF-8"))
                .andExpect(jsonPath("$.message").value("用户已存在"));
    }

}
