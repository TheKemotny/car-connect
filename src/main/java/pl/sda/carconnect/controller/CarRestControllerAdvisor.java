package pl.sda.carconnect.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
        String path = ServletUriComponentsBuilder.fromCurrentRequest().build().getPath();
        return ResponseDto.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .path(path)
                .build();
    }
}
