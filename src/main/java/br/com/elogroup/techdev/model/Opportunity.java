package br.com.elogroup.techdev.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
@Entity
public class Opportunity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Campo lead é obrigatório")
    @ManyToOne()
    private Lead lead;
    @NotEmpty(message = "Campo description é obrigatório")
    private String description;

    public Opportunity() {

    }

    public Opportunity(Lead lead, String description) {
        this.lead = lead;
        this.description = description;
    }
}