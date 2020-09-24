package br.com.elogroup.techdev.controller.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@EqualsAndHashCode
@Immutable
public class LeadDTO implements Serializable {

    @NotNull(message = "Campo date é obrigatório")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @NotEmpty(message = "Campo customerName é obrigatório")
    private String customerName;
    @NotEmpty(message = "Campo customerPhone é obrigatório")
    private String customerPhone;
    @NotEmpty(message = "Campo customerEmail é obrigatório")
    private String customerEmail;
    @NotEmpty(message = "Campo descriptionOpportunity é obrigatório")
    private String descriptionOpportunity;

    public LeadDTO(@NotNull(message = "Campo posicao é obrigatório") Date date,
                   @NotEmpty(message = "Campo custumerName é obrigatório") String customerName,
                   @NotEmpty(message = "Campo custumerPhone é obrigatório") String customerPhone,
                   @NotEmpty(message = "Campo custumerEmail é obrigatório") String customerEmail,
                   @NotEmpty(message = "Campo descriptionOpportunity é obrigatório") String descriptionOpportunity) {
        this.date = date;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.descriptionOpportunity = descriptionOpportunity;
    }
}
