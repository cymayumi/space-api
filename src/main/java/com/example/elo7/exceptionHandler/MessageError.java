package com.example.elo7.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageError {
    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;
    private List<Field> field;

    @AllArgsConstructor
    @Getter
    public static class Field {
        private String nome;
        private String mensagem;
    }

}
