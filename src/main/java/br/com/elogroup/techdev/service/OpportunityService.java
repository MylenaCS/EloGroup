package br.com.elogroup.techdev.service;

import br.com.elogroup.techdev.model.Opportunity;
import br.com.elogroup.techdev.repository.OpportunityRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Log4j2
@Service
@Validated
public class OpportunityService {

    private OpportunityRepository opportunityRepository;


    @Transactional
    public void salvar(@Valid @NotNull(message = "Objeto Request é obrigatório") Opportunity opportunity) {
        this.opportunityRepository.save(opportunity);
    }

    @Transactional
    public void atualizar(@NotNull(message = "Campo codigoLead é obrigatório") Long codigoLead) {

    }

    @Transactional
    public void remover(@NotNull(message = "Campo codigoLead é obrigatório") Long codigoOpportunity) {
        Opportunity opportunity = this.opportunityRepository.getOne(codigoOpportunity);
        this.opportunityRepository.delete(opportunity);
    }
}
