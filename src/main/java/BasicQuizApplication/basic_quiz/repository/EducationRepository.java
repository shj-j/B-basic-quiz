package BasicQuizApplication.basic_quiz.repository;

import BasicQuizApplication.basic_quiz.domain.Education;
import BasicQuizApplication.basic_quiz.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EducationRepository {
    private final List<Education> educationList = new ArrayList<>();

    {
        educationList.add(Education.builder()
                .description("Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus.")
                .year((long) 2005)
                .title("Secondary school specializing in artistic")
                .userId((long) 1)
                .build());

        educationList.add(Education.builder()
                .description("Aspernatur, mollitia, quos maxime eius suscipit sed beatae ducimus quaerat quibusdam perferendis? Iusto, quibusdam asperiores unde repellat.")
                .year((long) 2009)
                .title("First level graduation in Graphic Design")
                .userId((long) 1)
                .build());
    }
    public List<Education> findByUserId(Long id) {
        // GTB: - IDEA 都提示了不要用 ==
        return educationList.stream().filter(education -> education.getUserId() == id).collect(Collectors.toList());
    }

    public void save(Long id , Education education) {
        education.setUserId(id);
        educationList.add(education);
    }
}
