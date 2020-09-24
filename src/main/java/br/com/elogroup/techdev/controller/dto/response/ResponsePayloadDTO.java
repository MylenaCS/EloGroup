package br.com.elogroup.techdev.controller.dto.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Immutable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
@Immutable
public class ResponsePayloadDTO implements Serializable {
    @NotNull(message = "Campo id é obrigatório")
    private Long id;
    @NotEmpty(message = "Campo nome é obrigatório")
    private String nome;

    public ResponsePayloadDTO(@NotNull(message = "Campo id é obrigatório") Long id,
                              @NotEmpty(message = "Campo nome é obrigatório") String nome) {
        this.id = id;
        this.nome = nome;
    }
}
