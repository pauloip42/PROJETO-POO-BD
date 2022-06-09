package com.api.organograma.controllers;

import com.api.organograma.dtos.ClienteDto;
import com.api.organograma.models.ClienteModel;
import com.api.organograma.services.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/clientes")

public class ClienteController {
    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping // GET ALL Clients (READ)
    public ResponseEntity<List<ClienteModel>> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("{id}") // GET CLIENT BY ID (READ)
    public ResponseEntity<Object> getOneClient(@PathVariable(value = "id") Integer id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(clienteModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não cadastrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
    }

    @PostMapping // CREATE
    public ResponseEntity<Object> saveClient(@RequestBody @Valid ClienteDto clienteDto){
        if(clienteService.existsByResponsavel(clienteDto.getResponsavel())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Responsavel já tem um projeto");
        }
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }

    @PutMapping("{id}") // UPDATE CLIENT BY ID
    public ResponseEntity<Object> updateClient(@PathVariable(value = "id") Integer id,
                                               @RequestBody @Valid ClienteDto clienteDto){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if (clienteModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Inexistente");
        }
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);

        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
    }

    @DeleteMapping("{id}") // DELETE MEMBER
    public ResponseEntity<Object> deleteClient(@PathVariable(value = "id") Integer id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if (clienteModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Inexistente");
        }
        clienteService.delete(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente Deletado com Sucesso");
    }
}
