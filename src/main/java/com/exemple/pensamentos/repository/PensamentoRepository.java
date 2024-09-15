package com.example.pensamentos.repository;

import com.example.pensamentos.model.Pensamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PensamentoRepository extends JpaRepository<Pensamento, Long> {
    List<Pensamento> findByFavorito(boolean favorito);
    List<Pensamento> findByConteudoContaining(String filtro);
}
