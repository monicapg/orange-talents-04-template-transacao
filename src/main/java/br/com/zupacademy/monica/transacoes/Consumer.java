package br.com.zupacademy.monica.transacoes;

import br.com.zupacademy.monica.transacoes.transacoes.TransacaoRepository;
import br.com.zupacademy.monica.transacoes.transacoes.TransacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class Consumer {

    @Autowired
    TransacaoRepository transacaoRepository;

    @KafkaListener(groupId = "kafka_transacoes", topics = "transacoes")
    void transacoes(TransacaoRequest transacaoRequest) {
        System.out.println("TransacaoRequest: " + transacaoRequest.toString());
//        transacaoRepository.save(transacaoRequest.paraTransacao());
        transacaoRepository.save(transacaoRequest.paraTransacao());


    }

}
