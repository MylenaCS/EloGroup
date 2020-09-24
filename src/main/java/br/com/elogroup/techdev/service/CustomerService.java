package br.com.elogroup.techdev.service;

import br.com.elogroup.techdev.model.Customer;
import br.com.elogroup.techdev.repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Log4j2
@Service
@Validated
public class CustomerService {

    private CustomerRepository customerRepository;


    @Transactional
    public void salvar(@Valid @NotNull(message = "Objeto Request é obrigatório") Customer customer) {
        this.customerRepository.save(customer);
    }

    @Transactional
    public void atualizar(@NotNull(message = "Campo codigoLead é obrigatório") Long codigoLead) {

    }

    @Transactional
    public void remover(@NotNull(message = "Campo codigoLead é obrigatório") Long codigoCustomer) {
        Customer customer = this.customerRepository.getOne(codigoCustomer);
        this.customerRepository.delete(customer);
    }
}
