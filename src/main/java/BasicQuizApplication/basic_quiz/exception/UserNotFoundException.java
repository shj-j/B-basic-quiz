package BasicQuizApplication.basic_quiz.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);

    }
}
