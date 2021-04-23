package br.com.insiders.escola.exception.handler;

import br.com.insiders.escola.exception.ObjetoNaoEncontrado;
import br.com.insiders.escola.exception.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ErroObjetoHandler {

    @ExceptionHandler(ObjetoNaoEncontrado.class)
    public ResponseEntity<ErrorDto> objetoNaoEncontrado(ObjetoNaoEncontrado e, HttpServletRequest request){
        ErrorDto errorDto = ErrorDto.builder()
            .timestamp(Instant.now())
            .status(HttpStatus.NOT_FOUND.value())
            .error("Resource not found")
            .message(e.getMessage())
            .path(request.getRequestURI())
            .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }
}
