package com.itau.demo.dto;

import com.itau.demo.model.Contrato;
import com.itau.demo.model.Parcelada;

import java.io.Serializable;
import java.util.List;

public class ComunDTO  implements Serializable {

    private Contrato contrato;
    private List<Parcelada> parceladaList;

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public List<Parcelada> getParceladaList() {
        return parceladaList;
    }

    public void setParceladaList(List<Parcelada> parceladaList) {
        this.parceladaList = parceladaList;
    }
}
