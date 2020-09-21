package BasicQuizApplication.basic_quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Min(16)
    private Long age;
    private String avatar;
    private String description;

    public User(Long id, String name, Long age, String avatar, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.avatar = avatar;
        this.description = description;
    }
}
