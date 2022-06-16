package com.api.organograma.controllers;

import com.api.organograma.dtos.ProjetoDto;
import com.api.organograma.models.ClienteModel;
import com.api.organograma.models.MembroModel;
import com.api.organograma.models.ProjetoModel;
import com.api.organograma.repositories.MembroRepository;
import com.api.organograma.repositories.ProjetoRepository;
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
    final MembroService membroService;

    final ProjetoRepository projetoRepository;
    final MembroRepository membroRepository;

    public ProjetoController(ProjetoService projetoService, ClienteService clienteService, MembroService membroService, ProjetoRepository projetoRepository, MembroRepository membroRepository) {
        this.projetoService = projetoService;
        this.clienteService = clienteService;
        this.membroService = membroService;
        this.projetoRepository = projetoRepository;
        this.membroRepository = membroRepository;
    }


    @GetMapping // GET ALL MEMBERS (READ)
    public ResponseEntity<List<ProjetoModel>> getAllProjects() {
        return ResponseEntity.status(HttpStatus.OK).body(projetoService.findAll());
    }

    @PostMapping // CREATE
    public ResponseEntity<Object> saveProject(@RequestBody @Valid ProjetoDto projetoDto){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(projetoDto.getCliente());
        Optional<MembroModel> membroModelOptional = membroService.findById(projetoDto.getMembro());

        if(projetoService.existsByNome(projetoDto.getNome())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome já está cadastrado");
        }

        if (clienteModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Inexistente");
        }

        if(membroModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Membro Inexistente");
        }

        if(projetoService.existsByIdAndMember(projetoDto.getId(), membroModelOptional.get())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Membro já cadastrado no projeto");
        }

        var projetoModel = new ProjetoModel();
        var clienteModel = new ClienteModel();

        BeanUtils.copyProperties(projetoDto, projetoModel);

        clienteModel = clienteModelOptional.get();

        if(clienteModel.getProjeto() != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse cliente já tem um projeto");
        }

        projetoModel.setCliente(clienteModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.save(projetoModel, membroModelOptional.get()));
    }

    @PutMapping("/{id}/membros/{membroid}")
    public ResponseEntity<String> updateProjeto(
            @PathVariable(value = "id") Integer id,
            @PathVariable(value = "membroid") Integer membroId,
            @RequestBody @Valid String status
    ){
        if(!projetoService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto Inexistente");
        }

        if(!membroService.existsById(membroId)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Membro Inexistente");
        }

        if(!projetoService.validateStatus(status)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status Inválido");
        }

        ProjetoModel projetoModel = projetoRepository.getById(id);
        MembroModel membroModel = membroRepository.getById(membroId);

        projetoModel.addMembro(membroModel);
        projetoModel.setStatus(status);
        projetoService.saveUpdated(projetoModel);

        return ResponseEntity.status(HttpStatus.OK).body("Projeto Atualizado\n" + projetoService.saveUpdated(projetoModel));
    }

    @DeleteMapping("{id}") // DELETE Project
    public ResponseEntity<Object> deleteProject(@PathVariable(value = "id") Integer id){
        Optional<ProjetoModel> projetoModelOptional = projetoService.findById(id);
        if (projetoModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto Inexistente");
        }
        projetoService.delete(projetoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(projetoModelOptional.get());
    }
}
