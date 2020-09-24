package br.com.elogroup.techdev.controller;

import br.com.elogroup.techdev.controller.dto.request.LeadDTO;
import br.com.elogroup.techdev.controller.dto.response.CabecalhoDTO;
import br.com.elogroup.techdev.controller.dto.response.ResponsePayloadDTO;
import br.com.elogroup.techdev.model.Customer;
import br.com.elogroup.techdev.model.Lead;
import br.com.elogroup.techdev.service.LeadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Log4j2
@Api(value = "Lead", tags = {"Lead"})
@Validated
@RestController
@RequestMapping("/Lead")
public class LeadController {

    private LeadService leadService;

    @Autowired
    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transação realizada com Sucesso"),
            @ApiResponse(code = 500, message = "Ocorreu uma falha na plataforma."),
            @ApiResponse(code = 401, message = "As informações de autenticação necessárias estão ausentes ou não são válidas para o recurso."),
            @ApiResponse(code = 403, message = "Acesso negado ao recurso solicitado."),
            @ApiResponse(code = 404, message = "O recurso solicitado ou o endpoint não foi encontrado."),
            @ApiResponse(code = 406, message = "Este serviço não é compatível com o formato solicitado no cabeçalho Accept."),
            @ApiResponse(code = 400, message = "Solicitação Inválida")
    })
    public ResponseEntity<CabecalhoDTO> salvar(@Valid @NotNull(message = "Objeto request não encontrado") @RequestBody LeadDTO LeadDTO) {
        Customer customerPersistido = this.leadService.salvar(LeadDTO);
        ResponsePayloadDTO responsePayloadDTO = new ResponsePayloadDTO(customerPersistido.getLead().getId(), customerPersistido.getLead().getCustumerName());
        CabecalhoDTO cabecalhoDTO = new CabecalhoDTO("salvarLead","SUCESSO",responsePayloadDTO);
        return ResponseEntity.ok(cabecalhoDTO);
    }

    @DeleteMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transação realizada com Sucesso"),
            @ApiResponse(code = 500, message = "Ocorreu uma falha na plataforma."),
            @ApiResponse(code = 401, message = "As informações de autenticação necessárias estão ausentes ou não são válidas para o recurso."),
            @ApiResponse(code = 403, message = "Acesso negado ao recurso solicitado."),
            @ApiResponse(code = 404, message = "O recurso solicitado ou o endpoint não foi encontrado."),
            @ApiResponse(code = 406, message = "Este serviço não é compatível com o formato solicitado no cabeçalho Accept."),
            @ApiResponse(code = 400, message = "Solicitação Inválida")
    })
    public ResponseEntity<CabecalhoDTO> remover(@Valid @NotNull(message = "Objeto request não encontrado") @RequestBody Long idLead) {
        Lead lead = this.leadService.remover(idLead);
        ResponsePayloadDTO responsePayloadDTO = new ResponsePayloadDTO(lead.getId(), lead.getCustumerName());
        CabecalhoDTO cabecalhoDTO = new CabecalhoDTO("removerLead","SUCESSO",responsePayloadDTO);
        return ResponseEntity.ok(cabecalhoDTO);
    }

}
