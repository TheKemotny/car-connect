package pl.sda.carconnect.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.sda.carconnect.dto.ResponseDto;
import pl.sda.carconnect.exception.WrongClientIdException;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ClientRestControllerAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = WrongClientIdException.class)
    public ResponseDto handleClientNotFoundException(WrongClientIdException exception) {
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
}
