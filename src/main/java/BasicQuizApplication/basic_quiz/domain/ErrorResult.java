package BasicQuizApplication.basic_quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// GTB: - 这个 ErrorResult 貌似也没人在用了
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {
    private String message;
}