package br.com.zupacademy.monica.transacoes.transacoes;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

    List<Transacao> findByIdCartao(String idCartao);

}
