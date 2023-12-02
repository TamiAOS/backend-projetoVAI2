package br.com.projetovai.api.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorReponse {
    private String mensagem;
    private LocalDateTime data;
    private int status;
    private String path;
}
