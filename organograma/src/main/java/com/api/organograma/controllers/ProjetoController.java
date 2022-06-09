package com.api.organograma.controllers;

import com.api.organograma.dtos.MembroDto;
import com.api.organograma.dtos.ProjetoDto;
import com.api.organograma.models.ClienteModel;
import com.api.organograma.models.MembroModel;
import com.api.organograma.models.ProjetoModel;
import com.api.organograma.services.ClienteService;
import com.api.organograma.services.MembroService;
import com.api.organograma.services.ProjetoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/projetos")
public class ProjetoController {
    final ProjetoService projetoService;
    final ClienteService clienteService;

    public ProjetoController(ProjetoService projetoService, ClienteService clienteService) {
        this.projetoService = projetoService;
        this.clienteService = clienteService;
    }

    @GetMapping // GET ALL MEMBERS (READ)
    public ResponseEntity<List<ProjetoModel>> getAllProjects() {
        return ResponseEntity.status(HttpStatus.OK).body(projetoService.findAll());
    }

    @PostMapping // CREATE
    public ResponseEntity<Object> saveProject(@RequestBody @Valid ProjetoDto projetoDto){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(projetoDto.getCliente());

        if(projetoService.existsByNome(projetoDto.getNome())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome já está cadastrado");
        }

        if (clienteModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Inexistente");
        }

        var projetoModel = new ProjetoModel();
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(projetoDto, projetoModel);

        clienteModel = clienteModelOptional.get();

        if(clienteModel.getProjeto() != null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse cliente já tem um projeto");
        }

        projetoModel.setCliente(clienteModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.save(projetoModel));
    }

    @DeleteMapping("{id}") // DELETE Project
    public ResponseEntity<Object> deleteProject(@PathVariable(value = "id") Integer id){
        Optional<ProjetoModel> projetoModelOptional = projetoService.findById(id);
        if (projetoModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Membro Inexistente");
        }
        projetoService.delete(projetoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Membro Deletado com Sucesso");
    }
}
