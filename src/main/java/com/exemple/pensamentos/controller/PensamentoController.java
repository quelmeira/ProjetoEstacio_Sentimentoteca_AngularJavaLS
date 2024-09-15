package com.example.demo.controller;

import com.example.demo.model.Pensamento;
import com.example.demo.service.PensamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pensamentos")
public class PensamentoController {

    @Autowired
    private PensamentoService pensamentoService;

    @GetMapping
    public ResponseEntity<List<Pensamento>> getAllPensamentos() {
        List<Pensamento> pensamentos = pensamentoService.getAllPensamentos();
        return new ResponseEntity<>(pensamentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pensamento> getPensamentoById(@PathVariable Long id) {
        Pensamento pensamento = pensamentoService.getPensamentoById(id);
        if (pensamento != null) {
            return new ResponseEntity<>(pensamento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Pensamento> createPensamento(@RequestBody Pensamento pensamento) {
        Pensamento novoPensamento = pensamentoService.createPensamento(pensamento);
        return new ResponseEntity<>(novoPensamento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pensamento> updatePensamento(@PathVariable Long id, @RequestBody Pensamento pensamento) {
        Pensamento atualizado = pensamentoService.updatePensamento(id, pensamento);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePensamento(@PathVariable Long id) {
        if (pensamentoService.deletePensamento(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
