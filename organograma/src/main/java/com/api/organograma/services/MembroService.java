package com.api.organograma.services;

import com.api.organograma.models.MembroModel;
import com.api.organograma.repositories.MembroRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MembroService {

    final MembroRepository membroRepository;

    public MembroService(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }

    @Transactional
    public MembroModel save(MembroModel membroModel) {
        return membroRepository.save(membroModel);
    }

    public boolean existsByNome(String nome) {
        return membroRepository.existsByNome(nome);
    }

    public List<MembroModel> findAll() {
        return membroRepository.findAll();
    }

    public Optional<MembroModel> findById(Integer id) {
        return membroRepository.findById(id);
    }

    @Transactional // ANOTATION Para métodos construtivos ou destrutivos
    public void delete(MembroModel membroModel) {
        membroRepository.delete(membroModel);
    }
}
