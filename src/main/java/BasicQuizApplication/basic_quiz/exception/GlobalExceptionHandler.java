package BasicQuizApplication.basic_quiz.exception;

import BasicQuizApplication.basic_quiz.domain.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<ErrorResult> handleUserNotFound(UserNotFoundException ex) {
//        ErrorResult errorResult = new ErrorResult(ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
//    }
//    @ExceptionHandler(UserExistException.class)
//    public ResponseEntity<ErrorResult> handleUserExist(UserExistException ex) {
//        ErrorResult errorResult = new ErrorResult(ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
//    }
//}
