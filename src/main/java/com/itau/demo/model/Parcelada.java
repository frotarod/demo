package com.itau.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Parcelada {

    @JsonProperty("data_calculo")
    private Date dataCalculo;

    @JsonProperty("tipo_calculo")
    private String tipoCalculo;

    @JsonProperty("valor_total")
    private double total;

    @JsonProperty("quantidade_parcelas")
    private int qtdParcelas;

    @JsonProperty("valor_parcelas")
    private double valorParcela;

    @JsonProperty("dia_pagamento")
    private int diaPagamento;

    @JsonProperty("percentual_taxa_juro")
    private double perTxJuros;

    public Date getDataCalculo() {
        return dataCalculo;
    }

    public void setDataCalculo(Date dataCalculo) {
        this.dataCalculo = dataCalculo;
    }

    public String getTipoCalculo() {
        return tipoCalculo;
    }

    public void setTipoCalculo(String tipoCalculo) {
        this.tipoCalculo = tipoCalculo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public int getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    public double getPerTxJuros() {
        return perTxJuros;
    }

    public void setPerTxJuros(double perTxJuros) {
        this.perTxJuros = perTxJuros;
    }
}
