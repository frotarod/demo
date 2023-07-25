package com.itau.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PagamentoAdiantamentoAlteracaoDados {

    @JsonProperty("nova_data_pagamento")
    private int novaDtPg;

    public int getNovaDtPg() {
        return novaDtPg;
    }

    public void setNovaDtPg(int novaDtPg) {
        this.novaDtPg = novaDtPg;
    }
}
