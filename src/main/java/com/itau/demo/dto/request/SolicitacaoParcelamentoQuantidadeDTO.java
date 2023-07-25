package com.itau.demo.dto.request;

import com.itau.demo.dto.ComunDTO;

import com.itau.demo.model.PagamentoAdiantamentoAlteracaoDados;

public class SolicitacaoParcelamentoQuantidadeDTO extends ComunDTO {


    private PagamentoAdiantamentoAlteracaoDados adiantamentoQuantidadeParcelamento;

    public PagamentoAdiantamentoAlteracaoDados getAdiantamentoQuantidadeParcelamento() {
        return adiantamentoQuantidadeParcelamento;
    }

    public void setAdiantamentoQuantidadeParcelamento(PagamentoAdiantamentoAlteracaoDados adiantamentoQuantidadeParcelamento) {
        this.adiantamentoQuantidadeParcelamento = adiantamentoQuantidadeParcelamento;
    }
}
