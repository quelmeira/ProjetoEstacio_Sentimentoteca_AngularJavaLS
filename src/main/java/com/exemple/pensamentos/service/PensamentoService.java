package com.example.pensamentos.service;

import com.example.pensamentos.model.Pensamento;
import com.example.pensamentos.repository.PensamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PensamentoService {

    @Autowired
    private PensamentoRepository repository;

    public List<Pensamento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pensamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Pensamento> buscarFavoritos() {
        return repository.findByFavorito(true);
    }

    public List<Pensamento> buscarPorFiltro(String filtro) {
        return repository.findByConteudoContaining(filtro);
    }

    public Pensamento criar(Pensamento pensamento) {
        return repository.save(pensamento);
    }

    public Pensamento editar(Pensamento pensamento) {
        return repository.save(pensamento);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Pensamento mudarFavorito(Long id) {
        Pensamento pensamento = repository.findById(id).orElseThrow();
        pensamento.setFavorito(!pensamento.isFavorito());
        return repository.save(pensamento);
    }
}
