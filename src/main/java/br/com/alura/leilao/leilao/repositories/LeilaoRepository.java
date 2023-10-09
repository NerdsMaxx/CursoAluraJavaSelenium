package br.com.alura.leilao.leilao.repositories;

import br.com.alura.leilao.leilao.model.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long> {

}