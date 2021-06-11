package br.com.zupacademy.monica.transacoes.transacoes;

import br.com.zupacademy.monica.transacoes.cartao.Cartao;
import br.com.zupacademy.monica.transacoes.estabelecimento.Estabelecimento;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoRequest {

    @JsonProperty
    String id;
    @JsonProperty
    BigDecimal valor;
    @JsonProperty
    Estabelecimento estabelecimento;
    @JsonProperty
    Cartao cartao;
    @JsonProperty
    LocalDateTime efetivadaEm;

    @JsonCreator
    public TransacaoRequest(@JsonProperty("id") String id,
                            @JsonProperty("valor")BigDecimal valor,
                            @JsonProperty("estabelecimento")Estabelecimento estabelecimento,
                            @JsonProperty("cartao")Cartao cartao,
                            @JsonProperty("efetivadaEm")LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }




    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }


}
