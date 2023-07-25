package com.itau.demo.service;

import com.itau.demo.exception.PaymentsException;
import com.itau.demo.model.InteresseApi;
import com.itau.demo.model.Parcelada;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class RegrasService {

    private final static String ADITAMENTO = "ADITAMENTO";
    private final static int DIA_PAGAMENTO= 02;

    public static void validateQuantityInstallment(double currentInstallment, double installmentContract){
        if (installmentContract < currentInstallment) {
            throw new PaymentsException("Parcela é inferior a atual");
        }
    }

    public static void isIinstallmentInArrears(Boolean installmentInArrears){
        if(installmentInArrears.equals(true)){
            throw new PaymentsException("Contrato com parcelas em atraso");
        }
    }

    public static Double recalculatesValue(Double totalValue, Integer qtdinstallment){
        return totalValue / qtdinstallment;
    }

    public static Parcelada updatePaymentDay(Parcelada installments, int paymentDay) {
        Parcelada installment = new Parcelada();

        BeanUtils.copyProperties(installments,installment);
        installment.setTipoCalculo(ADITAMENTO);
        installment.setDiaPagamento(paymentDay);

        return installment;

    }

    public static void validatePaymentDate(Date date){

        LocalDate today =  LocalDate.now();

        LocalDate paymentDay = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long days = ChronoUnit.DAYS.between(today, paymentDay);

        if (days >= 10) {
            throw new PaymentsException("Dia de pagamento não pode estar mais que 10 dias adiante do dia atual de pagamento");
        }
    }

    public static Parcelada newInstallments(double valor, InteresseApi interesseApi, int advancePayment){


        Parcelada parcelada = new Parcelada();

        parcelada.setTotal(interesseApi.getTotal());

        parcelada.setValorParcela(valor);

        parcelada.setDiaPagamento(DIA_PAGAMENTO);
        parcelada.setQtdParcelas(advancePayment);

        parcelada.setTipoCalculo(ADITAMENTO);
        parcelada.setDataCalculo(new Date());

        parcelada.setPerTxJuros(interesseApi.getPercentJuros());

        return parcelada;
    }

    public static void isActiveContract(Boolean active){
        if(active.equals(false)){
            throw new PaymentsException("O contrato precisa estar ativo !");
        }
    }

}
