package br.com.zupacademy.monica.transacoes.controller;

import br.com.zupacademy.monica.transacoes.cartao.Cartao;
import br.com.zupacademy.monica.transacoes.cartao.CartaoRepository;
import br.com.zupacademy.monica.transacoes.transacoes.Transacao;
import br.com.zupacademy.monica.transacoes.transacoes.TransacaoRepository;
import br.com.zupacademy.monica.transacoes.transacoes.TransacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransacaoController {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    TransacaoRepository transacaoRepository;

    @GetMapping("/cartoes/{idCartao}")
    public ResponseEntity<?> consultaPorCartao(@PathVariable String idCartao) {

        //Se cartão existe, retornar lista de Transações
        if (cartaoRepository.existsById(idCartao)) {

            List<Transacao> ultimasTransacoes;
            ultimasTransacoes = transacaoRepository.findByIdCartao(idCartao);
            return ResponseEntity.ok().body(ultimasTransacoes);
        }
        return ResponseEntity.notFound().build();





    }



}
