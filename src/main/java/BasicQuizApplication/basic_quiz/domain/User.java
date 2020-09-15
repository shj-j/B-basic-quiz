package BasicQuizApplication.basic_quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    @Length(min=1, max =128)
    private String name;
    @Min(16)
    private Long age;
    @Length(min=8, max =512)
    private String avatar;
    @Length(max = 1024)
    private String description;
}
