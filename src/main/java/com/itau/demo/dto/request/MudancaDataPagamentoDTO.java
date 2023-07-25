package com.itau.demo.dto.request;

import com.itau.demo.dto.ComunDTO;
import com.itau.demo.model.AdiantamentoQuantidadeParcelamento;
import com.itau.demo.model.PagamentoAdiantamentoAlteracaoDados;


public class MudancaDataPagamentoDTO  extends ComunDTO {

    private AdiantamentoQuantidadeParcelamento adiantamentoQuantidadeParcelamento;

    public AdiantamentoQuantidadeParcelamento getAdiantamentoQuantidadeParcelamento() {
        return adiantamentoQuantidadeParcelamento;
    }

    public void setAdiantamentoQuantidadeParcelamento(AdiantamentoQuantidadeParcelamento adiantamentoQuantidadeParcelamento) {
        this.adiantamentoQuantidadeParcelamento = adiantamentoQuantidadeParcelamento;
    }
}
