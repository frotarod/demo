package com.itau.demo.controller;


import com.itau.demo.dto.request.SolicitacaoParcelamentoQuantidadeDTO;
import com.itau.demo.dto.response.AlterarDataPpagamentoDTO;
import com.itau.demo.dto.response.ParcelamentoQuantidadeDTO;
import com.itau.demo.exception.PaymentsException;
import com.itau.demo.service.OperacaoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PosVendaController {

    @Autowired
    private OperacaoService service;


    @RequestMapping(value =  "/qtd/parcelas", method = RequestMethod.POST)
    public ResponseEntity<ParcelamentoQuantidadeDTO> quantidadeParcela( HttpServletRequest request,
                                                                        HttpServletResponse response,
                                                                        @RequestBody SolicitacaoParcelamentoQuantidadeDTO parcelamentoQuantidadeDTO){

        String afterSalesHeader = request.getHeader("itau-pos-venda-teste:" + " UUID");

        if (afterSalesHeader == null ||
                !afterSalesHeader.matches("[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")) {
            throw new PaymentsException("'itau-pos-venda-teste' inválidado.");
        }
        response.addHeader("itau-pos-venda-teste", afterSalesHeader);
        return ResponseEntity.ok().body(service.quantityInstallment(parcelamentoQuantidadeDTO));
    }

    @RequestMapping(value =  "/alteracao/data", method = RequestMethod.POST)
    public ResponseEntity<AlterarDataPpagamentoDTO>  mudancaDtPagamento(HttpServletRequest request,
                                                                        HttpServletResponse response,
                                                                        @RequestBody SolicitacaoParcelamentoQuantidadeDTO pagamento) throws PaymentsException{
        String afterSalesHeader = request.getHeader("itau-pos-venda-teste:" + " UUID");
        if (afterSalesHeader == null ||
                !afterSalesHeader.matches("[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")) {
            throw new PaymentsException("'itau-pos-venda-teste' inválidado.");
        }
        response.addHeader("itau-pos-venda-teste", afterSalesHeader);
        return ResponseEntity.ok().body(service.changePaymentDate(pagamento));
    }
}
