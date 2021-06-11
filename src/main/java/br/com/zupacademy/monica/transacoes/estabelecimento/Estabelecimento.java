package br.com.zupacademy.monica.transacoes.estabelecimento;

import br.com.zupacademy.monica.transacoes.transacoes.Transacao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Estabelecimento {

    @Id
    Long id;
    String nome;
    String cidade;
    String endereco;
    @OneToMany(mappedBy = "estabelecimento")
    List<Transacao> transacoes;

    @Deprecated
    public Estabelecimento(){}

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

}
