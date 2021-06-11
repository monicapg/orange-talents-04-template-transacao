package br.com.zupacademy.monica.transacoes.transacoes;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
class KafkaConfiguration {

    //Kafka: String -> Json -> objeto
    @Bean
    StringJsonMessageConverter jsonMessageConverter() {
        return new StringJsonMessageConverter();
    }

}
