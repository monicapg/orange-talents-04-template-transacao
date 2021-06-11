package br.com.zupacademy.monica.transacoes;

import br.com.zupacademy.monica.transacoes.transacoes.Transacao;
import br.com.zupacademy.monica.transacoes.transacoes.TransacaoRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class Consumer {

    @KafkaListener(groupId = "kafka_transacoes", topics = "transacoes")
    void transacoes(TransacaoRequest transacaoRequest){
    System.out.println("teste: "+ transacaoRequest.getId());

    }

}
