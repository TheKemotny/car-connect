package pl.sda.carconnect.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.sda.carconnect.dto.ResponseDto;
import pl.sda.carconnect.exception.WrongCarIdException;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class CarRestControllerAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = WrongCarIdException.class)
    public ResponseDto handleCarNotFoundException(WrongCarIdException exception) {
        return ResponseDto.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .path(getCurrentRequestPath())
                .build();
    }

    private static String getCurrentRequestPath() {
        return ServletUriComponentsBuilder.fromCurrentRequest().build().getPath();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, DataIntegrityViolationException.class})
    public ResponseDto handleBadRequestException(Exception exception) {
        return ResponseDto.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .path(getCurrentRequestPath())
                .build();
    }

}
