package br.com.zupacademy.monica.transacoes.cartao;

import br.com.zupacademy.monica.transacoes.transacoes.Transacao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cartao {

    @Id
    String id;
    String email;
    @OneToMany(mappedBy = "cartao")
    List<Transacao> transacoes;

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}