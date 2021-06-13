package br.com.zupacademy.monica.transacoes.transacoes;

import br.com.zupacademy.monica.transacoes.cartao.Cartao;
import br.com.zupacademy.monica.transacoes.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
public class Transacao {

    @Id
    String id;
    BigDecimal valor;
    @ManyToOne(cascade = CascadeType.ALL)
    Estabelecimento estabelecimento;
    @ManyToOne(cascade = CascadeType.ALL)
    Cartao cartao;
    LocalDateTime efetivadaEm;

    public Transacao(TransacaoRequest transacaoRequest) {
        this.id = transacaoRequest.getId();
        this.valor = transacaoRequest.getValor();
        this.estabelecimento = transacaoRequest.getEstabelecimento();
        this.cartao = transacaoRequest.getCartao();
        this.efetivadaEm = transacaoRequest.getEfetivadaEm();

    }
    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    @Deprecated
    public Transacao(){}

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
