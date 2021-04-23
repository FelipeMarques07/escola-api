package br.com.insiders.escola.exception.dto;

import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class ErroDeFormularioDto {

    private Instant horario;
    private String campo;
    private String erro;

    public ErroDeFormularioDto(String campo, String erro) {
        this.horario = Instant.now();
        this.campo = campo;
        this.erro = erro;
    }
}
