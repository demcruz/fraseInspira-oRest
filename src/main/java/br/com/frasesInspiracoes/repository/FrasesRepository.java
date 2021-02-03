package br.com.frasesInspiracoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.frasesInspiracoes.entity.Frases;

@Repository
public interface FrasesRepository extends JpaRepository<Frases, Long> {

}
