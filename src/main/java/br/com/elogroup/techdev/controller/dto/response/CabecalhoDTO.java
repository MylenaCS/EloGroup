package br.com.elogroup.techdev.controller.dto.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Immutable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
@Immutable
public class CabecalhoDTO implements Serializable {
    @NotEmpty(message = "Campo metodo é obrigatório")
    private String metodo;
    @NotEmpty(message = "Campo resultado é obrigatório")
    private String resultado;
    @NotNull(message = "Campo payload é obrigatório")
    private ResponsePayloadDTO payload;

    public CabecalhoDTO( @NotEmpty(message = "Campo metodo é obrigatório") String metodo,
                         @NotEmpty(message = "Campo resultado é obrigatório") String resultado,
                         @Valid @NotNull(message = "Campo payload é obrigatório") ResponsePayloadDTO payload) {
        this.metodo = metodo;
        this.resultado = resultado;
        this.payload = payload;
    }
}
