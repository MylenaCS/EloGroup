package br.com.elogroup.techdev.model.domain;

public enum StatusLead implements IBasicDominio {

    ATIVO("ATIVO"),
    INATIVO("INATVO");

    private String description;

    StatusLead(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

}
