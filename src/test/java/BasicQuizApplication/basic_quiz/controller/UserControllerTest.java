package BasicQuizApplication.basic_quiz.controller;

import BasicQuizApplication.basic_quiz.repository.EducationRepository;
import BasicQuizApplication.basic_quiz.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

}
