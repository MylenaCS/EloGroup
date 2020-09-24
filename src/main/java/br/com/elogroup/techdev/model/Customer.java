package br.com.elogroup.techdev.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Campo lead é obrigatório")
    @ManyToOne(cascade = CascadeType.ALL)
    private Lead lead;

    public Customer() {
    }

    public Customer(@Valid @NotNull(message = "Campo lead é obrigatório") Lead lead) {
        this.lead = lead;
    }
}