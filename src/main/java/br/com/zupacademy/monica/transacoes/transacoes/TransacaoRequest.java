package br.com.zupacademy.monica.transacoes.transacoes;

import br.com.zupacademy.monica.transacoes.cartao.Cartao;
import br.com.zupacademy.monica.transacoes.estabelecimento.Estabelecimento;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @Deprecated
    public TransacaoRequest() {
    }

    @JsonCreator
    public TransacaoRequest(@JsonProperty("id") String id,
                            @JsonProperty("valor") BigDecimal valor,
                            @JsonProperty("estabelecimento") Estabelecimento estabelecimento,
                            @JsonProperty("cartao") Cartao cartao,
                            @JsonProperty("efetivadaEm") LocalDateTime efetivadaEm) {
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

    @Override
    public String toString() {
        return "TransacaoRequest{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }

    //    public Transacao paraTransacao() {
//        return new Transacao(
//                UUID.fromString(this.idCartao),
//                this.valor,
//                this.estabelecimento,
//                this.cartao,
//                this.efetivadaEm);
//
//    }
    public Transacao paraTransacao() {
        return new Transacao(
                this.id,
                this.valor,
                this.estabelecimento,
                this.cartao,
                this.efetivadaEm);
    }
}
