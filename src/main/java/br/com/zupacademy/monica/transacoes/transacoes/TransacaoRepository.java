package br.com.zupacademy.monica.transacoes.transacoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {

    //    @Query("select t from Transacao t where t.cartao.idCartao = :idCartao")
    // select t from... nao splita as colunas de transacao
    //@Query(value = "select * from Transacao t where t.cartao_id = :id", nativeQuery = true)

    @Query(
            value = "select * from Transacao t where t.cartao_id = :id order by t.efetivada_em desc limit 10",
            nativeQuery = true
    )
    List<Transacao> findByCartaoId(String id);

    List<Transacao> findFirst10ByCartaoIdOrderByEfetivadaEmDesc(String id);


}
