package com.itau.demo.service;


import com.itau.demo.dto.request.SolicitacaoParcelamentoQuantidadeDTO;
import com.itau.demo.dto.response.AlterarDataPpagamentoDTO;
import com.itau.demo.dto.response.ParcelamentoQuantidadeDTO;
import com.itau.demo.exception.PaymentsException;
import com.itau.demo.model.Contrato;

import com.itau.demo.model.InteresseApi;
import com.itau.demo.model.Parcelada;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OperacaoService {

    private static int PERCENTUAL_JUROS = 2;
    private static double  TOTAL = 10000.00;
    private InteresseApi requestInterestApiApi(Contrato contract, Parcelada installments)throws PaymentsException {
        InteresseApi returnInterestApi = new InteresseApi();
        returnInterestApi.setTotal(TOTAL);
        returnInterestApi.setPercentJuros(PERCENTUAL_JUROS);
        return returnInterestApi;
    }


    public AlterarDataPpagamentoDTO changePaymentDate(SolicitacaoParcelamentoQuantidadeDTO requestDTO) throws PaymentsException {
        try{
            var response = new AlterarDataPpagamentoDTO();

            RegrasService.validatePaymentDate(requestDTO.getParceladaList().get(0).getDataCalculo());

            RegrasService.isActiveContract(requestDTO.getContrato().getAtivo());
            RegrasService.isIinstallmentInArrears(requestDTO.getContrato().getParcelaAtraso());


            BeanUtils.copyProperties(requestDTO,response);

            Parcelada installments = RegrasService.updatePaymentDay(requestDTO.getParceladaList().get(requestDTO.getParceladaList().size() - 1), requestDTO.getAdiantamentoQuantidadeParcelamento().getNovaDtPg());
            response.getParceladaList().add(installments);
            return response;

        }catch (PaymentsException e){
            throw new PaymentsException(e.getMessage());
        }

    }

    public ParcelamentoQuantidadeDTO quantityInstallment(SolicitacaoParcelamentoQuantidadeDTO quantityInstallment) throws PaymentsException {

        try{
            RegrasService.isActiveContract(quantityInstallment.getContrato().getAtivo());
            RegrasService.validateQuantityInstallment(quantityInstallment.getParceladaList().get(quantityInstallment.getParceladaList().size() - 1).getQtdParcelas()
                    ,quantityInstallment.getAdiantamentoQuantidadeParcelamento().getNovaDtPg());

            InteresseApi returnInterestApi = requestInterestApiApi(quantityInstallment.getContrato(),quantityInstallment.getParceladaList().get(quantityInstallment.getParceladaList().size() - 1));

            double installmentAmount = RegrasService.recalculatesValue(returnInterestApi.getTotal(), quantityInstallment.getAdiantamentoQuantidadeParcelamento().getNovaDtPg());

            Parcelada parcelada = RegrasService.newInstallments(installmentAmount,returnInterestApi,quantityInstallment.getAdiantamentoQuantidadeParcelamento().getNovaDtPg());

            var response = new ParcelamentoQuantidadeDTO();

            BeanUtils.copyProperties(quantityInstallment,response);
            response.getParceladaList().add(parcelada);

            return response;

        }catch (PaymentsException e){
            throw new PaymentsException(e.getMessage());
        }

    }


}
