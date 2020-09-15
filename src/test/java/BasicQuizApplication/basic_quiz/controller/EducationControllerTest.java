package BasicQuizApplication.basic_quiz.controller;

import BasicQuizApplication.basic_quiz.domain.Education;
import BasicQuizApplication.basic_quiz.repository.EducationRepository;
import BasicQuizApplication.basic_quiz.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EducationControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    EducationRepository educationRepository;

    @Test
    void should_get_user_educations() throws Exception {
        mockMvc.perform(get("/users/1/educations"))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].year").value(2005))
                .andExpect(status().isOk());
    }
    @Test
    void should_add_education_if_user_exist() throws Exception {
        Education education = Education.builder()
                .year((long) 2009)
                .title("First level graduation in Graphic Design")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut fuga aliquam ad asperiores voluptatem dolorum! Quasi.")
                .build();
        String data = new ObjectMapper().writeValueAsString(education);

        mockMvc.perform(post("/users/1/educations")
                .content(data)
                .contentType("application/json;charset=UTF-8")
                .characterEncoding("UTF-8"))
                .andExpect(status().isCreated());
        assertEquals( educationRepository.findByUserId((long)1).size(), 3);
    }

    @Test
    void should_not_add_education_if_description_not_valid() throws Exception {
        Education education = Education.builder()
                .year((long) 2009)
                .title("First level graduation in Graphic Design")
                .description("")
                .build();
        String data = new ObjectMapper().writeValueAsString(education);

        mockMvc.perform(post("/users/1/educations")
                .content(data)
                .contentType("application/json;charset=UTF-8")
                .characterEncoding("UTF-8"))
                .andExpect(status().isBadRequest());
        assertEquals( educationRepository.findByUserId((long)1).size(), 2);
    }
}
