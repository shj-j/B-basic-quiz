package BasicQuizApplication.basic_quiz.exception;

public class UserExistException extends RuntimeException {
    public UserExistException (String message){
        super(message);
    }
}
