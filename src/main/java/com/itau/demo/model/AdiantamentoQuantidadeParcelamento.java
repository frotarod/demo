package com.itau.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdiantamentoQuantidadeParcelamento {

    @JsonProperty("nova_quantidade_parcelas")
    private Long qtdParceas;

    public Long getQtdParceas() {
        return qtdParceas;
    }

    public void setQtdParceas(Long qtdParceas) {
        this.qtdParceas = qtdParceas;
    }
}
