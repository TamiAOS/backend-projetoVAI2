package br.com.projetovai.api.exception.handler;

import br.com.projetovai.api.exception.AlunoException;
import br.com.projetovai.api.exception.InstituicaoException;
import br.com.projetovai.api.exception.ONGException;
import br.com.projetovai.api.exception.ProjetoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(AlunoException.class)
    public ResponseEntity<ErrorReponse> handlerAlunoException(AlunoException alunoException, HttpServletRequest request){
        return response(alunoException.getMessage(), request, HttpStatus.BAD_REQUEST, LocalDateTime.now());
    }
    @ExceptionHandler(InstituicaoException.class)
    public ResponseEntity<ErrorReponse> handlerInstituicaoException(InstituicaoException instituicaoException, HttpServletRequest request){
        return response(instituicaoException.getMessage(), request, HttpStatus.BAD_REQUEST, LocalDateTime.now());
    }
    @ExceptionHandler(ONGException.class)
    public ResponseEntity<ErrorReponse> handlerONGException(ONGException ongException, HttpServletRequest request){
        return response(ongException.getMessage(), request, HttpStatus.BAD_REQUEST, LocalDateTime.now());
    }
    @ExceptionHandler(ProjetoException.class)
    public ResponseEntity<ErrorReponse> handlerProjetoException(ProjetoException projetoException, HttpServletRequest request){
        return response(projetoException.getMessage(), request, HttpStatus.BAD_REQUEST, LocalDateTime.now());
    }
    private ResponseEntity<ErrorReponse> response(final String message, final HttpServletRequest request, final HttpStatus status, LocalDateTime data) {
        return ResponseEntity
                .status(status)
                .body(new ErrorReponse(message, data, status.value(), request.getRequestURI()));
    }

}
