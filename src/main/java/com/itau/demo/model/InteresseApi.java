package com.itau.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InteresseApi {


    @JsonProperty("percentual_juros")
    private double percentJuros;

    @JsonProperty("valor_total")
    private double total;

    public double getPercentJuros() {
        return percentJuros;
    }

    public void setPercentJuros(double percentJuros) {
        this.percentJuros = percentJuros;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
