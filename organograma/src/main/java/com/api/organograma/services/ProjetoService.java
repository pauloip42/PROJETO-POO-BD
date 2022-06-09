package com.api.organograma.services;

import com.api.organograma.models.ClienteModel;
import com.api.organograma.models.ProjetoModel;
import com.api.organograma.repositories.ProjetoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    // VERIFICA SE O PROJETO JÁ ESTÁ CADASTRADO
    public boolean existsByNome(String nome) {
        return projetoRepository.existsByNome(nome);
    }
    
    // Lista Projetos
    public List<ProjetoModel> findAll() {
        return (List<ProjetoModel>) projetoRepository.findAll();
    }

    // ENCONTRA Projeto POR ID
    public Optional<ProjetoModel> findById(Integer id) {
        return projetoRepository.findById(id);
    }
    
    // REGISTRA NOVO PROJETO
    @Transactional
    public ProjetoModel save(ProjetoModel projetoModel) {
        return projetoRepository.save(projetoModel);
    }

    // DELETA PROJETO
    @Transactional // ANOTATION Para métodos construtivos ou destrutivos
    public void delete(ProjetoModel projetoModel) {
        projetoRepository.delete(projetoModel);
    }
}
