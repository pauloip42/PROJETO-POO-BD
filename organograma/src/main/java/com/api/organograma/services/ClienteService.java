package com.api.organograma.services;

import com.api.organograma.models.ClienteModel;
import com.api.organograma.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    final ClienteRepository clienteRepository;

    // CONSTRUTOR
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // VERIFICA SE O RESPONSAVEL JÁ ESTÁ CADASTRADO (1 cliente tem apenas 1 projeto)
    public boolean existsByResponsavel(String responsavel) {
        return clienteRepository.existsByResponsavel(responsavel);
    }

    // ENCONTRA CLIENTE POR ID
    public Optional<ClienteModel> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    // LISTA CLIENTES
    public List<ClienteModel> findAll() {
        return (List<ClienteModel>) clienteRepository.findAll();
    }

    // CRIA NOVO CLIENTE
    @Transactional
    public ClienteModel save(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }

    // DELETA CLIENTE
    @Transactional // ANOTATION Para métodos construtivos ou destrutivos
    public void delete(ClienteModel clienteModel) {
        clienteRepository.delete(clienteModel);
    }
}
