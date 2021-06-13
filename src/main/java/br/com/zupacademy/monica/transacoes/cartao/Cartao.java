package br.com.zupacademy.monica.transacoes.cartao;

import br.com.zupacademy.monica.transacoes.transacoes.Transacao;
import br.com.zupacademy.monica.transacoes.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

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
    @JsonView(Views.Detailed.class)
    List<Transacao> transacoes;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", transacoes=" + transacoes +
                '}';
    }
}