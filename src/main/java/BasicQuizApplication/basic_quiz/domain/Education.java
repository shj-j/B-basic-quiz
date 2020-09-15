package BasicQuizApplication.basic_quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Education {
    private Long userId;
    private Long year;
    @Length(min = 1, max = 256)
    private String title;
    @Length(min = 1, max = 4096)
    private String description;
}
