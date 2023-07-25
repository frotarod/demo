package com.itau.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contrato {

    @JsonProperty("id_contrato")
    private Long id;
    @JsonProperty("ultimo_digito")
    private String utimoDigito;
    @JsonProperty("cliente_cpf_cnpj")
    private String cpfCliente;
    @JsonProperty("data_contratacao")
    private String data;
    @JsonProperty("ativo")
    private Boolean ativo;
    @JsonProperty("parcelas_em_atraso")
    private Boolean parcelaAtraso;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUtimoDigito() {
        return utimoDigito;
    }

    public void setUtimoDigito(String utimoDigito) {
        this.utimoDigito = utimoDigito;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getParcelaAtraso() {
        return parcelaAtraso;
    }

    public void setParcelaAtraso(Boolean parcelaAtraso) {
        this.parcelaAtraso = parcelaAtraso;
    }
}
