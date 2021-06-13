package br.com.zupacademy.monica.transacoes.transacoes;

import br.com.zupacademy.monica.transacoes.cartao.Cartao;
import br.com.zupacademy.monica.transacoes.estabelecimento.Estabelecimento;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    BigDecimal valor;
    @ManyToOne(cascade = CascadeType.ALL)
    Estabelecimento estabelecimento;
    @ManyToOne(cascade = CascadeType.ALL)
    Cartao cartao;
    LocalDateTime efetivadaEm;


    public Transacao(TransacaoRequest transacaoRequest) {

        //this.id = UUID.fromString(transacaoRequest.getIdCartao());
        this.id = transacaoRequest.getIdCartao();
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


}
