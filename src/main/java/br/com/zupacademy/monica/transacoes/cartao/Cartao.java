package br.com.zupacademy.monica.transacoes.cartao;

import br.com.zupacademy.monica.transacoes.transacoes.Transacao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cartao {

    @Id
    String idCartao;
    String email;
    @OneToMany(mappedBy = "cartao")
    List<Transacao> transacoes;


    @Deprecated
    public Cartao(){}

    public Cartao(String idCartao, String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

    public void setIdCartao(String idCartao) {
        this.idCartao = idCartao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id='" + idCartao + '\'' +
                ", email='" + email + '\'' +
                ", transacoes=" + transacoes +
                '}';
    }
}