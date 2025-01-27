package it.epicode.Capstone.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String fieldName = violation.getPropertyPath().toString();
            if (fieldName.contains(".")) {
                fieldName = fieldName.substring(fieldName.lastIndexOf('.') + 1);
            }
            errors.put(fieldName, violation.getMessage());

        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BadRequestException .class)
    protected ResponseEntity<Object> handleBadRequestError(BadRequestException  e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ConflictException  .class)
    protected ResponseEntity<Object> handleConflictError(ConflictException   e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = InternalServerErrorException   .class)
    protected ResponseEntity<Object> handleInternalServerError(InternalServerErrorException    e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ReservationNotFoundException.class)
    protected ResponseEntity<Object> handleReservationNotFoundError(ReservationNotFoundException e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundError(ResourceNotFoundException e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    protected ResponseEntity<Object> handleUnauthorizedError(UnauthorizedException e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = UploadException.class)
    protected ResponseEntity<String> handleUploadError(UploadException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    } // USATA?? DA CANCELLARE??

    @ExceptionHandler(value = UserNotFoundException.class)
    protected ResponseEntity<String> handleUserNotFoundError(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /*@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }*/

    /*@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
