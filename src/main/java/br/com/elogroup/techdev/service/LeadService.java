package br.com.elogroup.techdev.service;

import br.com.elogroup.techdev.controller.dto.request.LeadDTO;
import br.com.elogroup.techdev.model.Customer;
import br.com.elogroup.techdev.model.Lead;
import br.com.elogroup.techdev.model.Opportunity;
import br.com.elogroup.techdev.model.domain.StatusLead;
import br.com.elogroup.techdev.repository.LeadRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Log4j2
@Service
@Validated
public class LeadService {

    private LeadRepository leadRepository;
    private CustomerService customerService;
    private OpportunityService opportunityService;

    @Autowired
    public LeadService(LeadRepository leadRepository, CustomerService customerService, OpportunityService opportunityService) {
        this.leadRepository = leadRepository;
        this.customerService = customerService;
        this.opportunityService = opportunityService;
    }

    @Transactional
    public Customer salvar(@Valid @NotNull(message = "Objeto Request é obrigatório") LeadDTO LeadDTO) {
        Lead lead = new Lead(LeadDTO.getDate(), LeadDTO.getCustomerName(), LeadDTO.getCustomerPhone(), LeadDTO.getCustomerEmail(), StatusLead.ATIVO);
        Customer customer = new Customer(lead);
        saveOpportunity(lead, LeadDTO.getDescriptionOpportunity());
        this.customerService.salvar(customer);
        return customer;
    }

    private void saveOpportunity(Lead lead, String description){
        Opportunity opportunity = new Opportunity(lead, description);
        opportunityService.salvar(opportunity);
    }

    @Transactional
    public Lead remover(@NotNull(message = "Campo codigoLead é obrigatório") Long codigoLead){
        Lead lead = this.leadRepository.getOne(codigoLead);
        if(lead == null){
            log.info("Código não existe!");
        }
        Lead leadNovo = lead.atualizaStatus(StatusLead.INATIVO);
        this.leadRepository.save(leadNovo);
        return lead;
    }
}
