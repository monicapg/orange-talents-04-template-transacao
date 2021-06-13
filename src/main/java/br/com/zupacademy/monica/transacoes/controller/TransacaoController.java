package br.com.zupacademy.monica.transacoes.controller;

import br.com.zupacademy.monica.transacoes.cartao.CartaoRepository;
import br.com.zupacademy.monica.transacoes.transacoes.Transacao;
import br.com.zupacademy.monica.transacoes.transacoes.TransacaoRepository;
import br.com.zupacademy.monica.transacoes.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    TransacaoRepository transacaoRepository;

    @JsonView(Views.Simple.class)
    @GetMapping("/cartoes/{idCartao}")
    public ResponseEntity<?> consultaPorCartao(@PathVariable String idCartao) {

        //Se cartão existe, retornar lista de Transações
        if (cartaoRepository.existsById(idCartao)) {

            List<Transacao> ultimasTransacoes;
            ultimasTransacoes = transacaoRepository
                    .findFirst10ByCartaoIdOrderByEfetivadaEmDesc(idCartao);
            return ResponseEntity.ok().body(ultimasTransacoes);

        }

        return ResponseEntity.notFound().build();

    }

//    @JsonView(Views.Simple.class)
//    @GetMapping("/cartoesQ/{idCartao}")
//    public ResponseEntity<?> consultaPorCartaoQuery(@PathVariable String idCartao) {
//
//        //Se cartão existe, retornar lista de Transações
//        if (cartaoRepository.existsById(idCartao)) {
//
//            List<Transacao> ultimasTransacoes;
//            ultimasTransacoes = transacaoRepository
//                    .findByCartaoId(idCartao);
//            return ResponseEntity.ok().body(ultimasTransacoes);
//
//        }
//
//        return ResponseEntity.notFound().build();
//
//    }
}