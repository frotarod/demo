package com.itau.demo.dto.response;

import com.itau.demo.dto.ComunDTO;
import com.itau.demo.model.PagamentoAdiantamentoAlteracaoDados;

public class AlterarDataPpagamentoDTO extends ComunDTO {
    private PagamentoAdiantamentoAlteracaoDados alteracaoDados;

    public PagamentoAdiantamentoAlteracaoDados getAlteracaoDados() {
        return alteracaoDados;
    }

    public void setAlteracaoDados(PagamentoAdiantamentoAlteracaoDados alteracaoDados) {
        this.alteracaoDados = alteracaoDados;
    }
}
