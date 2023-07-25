package com.itau.demo.service;

import com.itau.demo.dto.request.SolicitacaoParcelamentoQuantidadeDTO;
import com.itau.demo.dto.response.AlterarDataPpagamentoDTO;
import com.itau.demo.exception.PaymentsException;
import com.itau.demo.model.Contrato;
import com.itau.demo.model.PagamentoAdiantamentoAlteracaoDados;
import com.itau.demo.model.Parcelada;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
public class OperationsServiceTest {

    @Autowired
    private OperacaoService operationsService;

    @Test
    void testChangePaymentDate() throws PaymentsException {

        Parcelada parcelada = new Parcelada();
        Date date = new Date();
        parcelada.setDataCalculo(date);
        parcelada.setDiaPagamento(2);
        parcelada.setTotal(1000);

        Contrato contract = new Contrato();
        contract.setAtivo(true);
        contract.setParcelaAtraso(false);

        PagamentoAdiantamentoAlteracaoDados paymentAdvanceAlterationData = new PagamentoAdiantamentoAlteracaoDados();
        paymentAdvanceAlterationData.setNovaDtPg(2);

        List<Parcelada> installmentsList = new ArrayList<>();
        installmentsList.add(parcelada);

        SolicitacaoParcelamentoQuantidadeDTO requestDTO = new SolicitacaoParcelamentoQuantidadeDTO();
        requestDTO.setContrato(contract);
        requestDTO.setParceladaList(installmentsList);
        requestDTO.setAdiantamentoQuantidadeParcelamento(paymentAdvanceAlterationData);

        AlterarDataPpagamentoDTO responseDTO = operationsService.changePaymentDate(requestDTO);

        assertNotNull(responseDTO);
        assertEquals(2, responseDTO.getParceladaList().get(0).getDiaPagamento());

    }






}
