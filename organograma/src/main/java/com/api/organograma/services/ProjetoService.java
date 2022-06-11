package com.api.organograma.services;

import com.api.organograma.models.MembroModel;
import com.api.organograma.models.ProjetoModel;
import com.api.organograma.repositories.ProjetoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    final ProjetoRepository projetoRepository;
    final MembroService membroService;

    public ProjetoService(ProjetoRepository projetoRepository, MembroService membroService) {
        this.projetoRepository = projetoRepository;
        this.membroService = membroService;
    }

    // VERIFICA SE O PROJETO JÁ ESTÁ CADASTRADO
    public boolean existsByNome(String nome) {
        return projetoRepository.existsByNome(nome);
    }
    
    // Lista Projetos
    public List<ProjetoModel> findAll() {
        return projetoRepository.findAll();
    }

    // ENCONTRA Projeto POR ID
    public Optional<ProjetoModel> findById(Integer id) {
        return projetoRepository.findById(id);
    }

    public boolean existsByIdAndMember(Integer id, MembroModel membro) {
        return projetoRepository.existsByIdAndMembro(id, membro);
    }
    
    // REGISTRA NOVO PROJETO
    @Transactional
    public ProjetoModel save(ProjetoModel projetoModel, MembroModel membroModel) {
        ProjetoModel auxProjetoModel = projetoRepository.save(projetoModel);
        membroService.addMembro(membroModel, projetoModel);

        return auxProjetoModel;
    }

    @Transactional
    public ProjetoModel saveUpdated(ProjetoModel projetoModel){
        return projetoRepository.save(projetoModel);
    }

    // DELETA PROJETO
    @Transactional // ANOTATION Para métodos construtivos ou destrutivos
    public void delete(ProjetoModel projetoModel) {
        projetoRepository.delete(projetoModel);
    }
}
