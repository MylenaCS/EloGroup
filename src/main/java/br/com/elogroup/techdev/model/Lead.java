package br.com.elogroup.techdev.model;


import br.com.elogroup.techdev.model.domain.StatusLead;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@EqualsAndHashCode
@Entity
@Immutable
public class Lead implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Campo date é obrigatório")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @NotEmpty(message = "Campo custumerName é obrigatório")
    private String custumerName;
    @NotEmpty(message = "Campo custumerPhone é obrigatório")
    private String custumerPhone;
    @NotEmpty(message = "Campo custumerEmail é obrigatório")
    private String custumerEmail;
    @NotNull(message = "Campo statusId é obrigatório")
    private StatusLead statusId;

    public Lead() {
    }

    public Lead(@NotNull(message = "Campo date é obrigatório") Date date,
                @NotNull(message = "Campo custumerName é obrigatório") String custumerName,
                @NotNull(message = "Campo custumerPhone é obrigatório") String custumerPhone,
                @NotNull(message = "Campo custumerEmail é obrigatório") String custumerEmail,
                @NotNull(message = "Campo statusId é obrigatório") StatusLead statusId) {
        this.date = date;
        this.custumerName = custumerName;
        this.custumerPhone = custumerPhone;
        this.custumerEmail = custumerEmail;
        this.statusId = statusId;
    }

    public Lead atualizaStatus(StatusLead statusLead){
        return new Lead(this.date, this.custumerName, this.custumerPhone, this.custumerEmail, statusLead);
    }


}