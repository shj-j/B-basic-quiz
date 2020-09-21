package BasicQuizApplication.basic_quiz.repository;

import BasicQuizApplication.basic_quiz.domain.Education;
import BasicQuizApplication.basic_quiz.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
      List<Education> findAllByUserId(Long userId);
}
