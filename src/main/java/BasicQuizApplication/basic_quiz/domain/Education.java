package BasicQuizApplication.basic_quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;
    private Long year;
    @Length(min = 1, max = 256)
    private String title;
    @Length(min = 1, max = 4096)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Education(Long id, Long userId, Long year, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.year = year;
        this.title = title;
        this.description = description;
    }
}
