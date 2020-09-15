package BasicQuizApplication.basic_quiz.exception;

import java.util.Date;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);

    }
}
