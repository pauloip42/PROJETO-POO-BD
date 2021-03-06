package com.api.organograma.controllers;

import com.api.organograma.dtos.MembroDto;
import com.api.organograma.models.MembroModel;
import com.api.organograma.models.NucleoModel;
import com.api.organograma.repositories.MembroRepository;
import com.api.organograma.repositories.NucleoRepository;
import com.api.organograma.services.MembroService;
import com.api.organograma.services.NucleoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/membros")

public class MembroController {
    final MembroService membroService;
    final NucleoRepository nucleoRepository;
    final MembroRepository membroRepository;
    final NucleoService nucleoService;

    public MembroController(MembroService membroService, NucleoRepository nucleoRepository, MembroRepository membroRepository, NucleoService nucleoService) {
        this.membroService = membroService;
        this.nucleoRepository = nucleoRepository;
        this.membroRepository = membroRepository;
        this.nucleoService = nucleoService;
    }

    @GetMapping // GET ALL MEMBERS (READ)
    public ResponseEntity<List<MembroModel>> getAllMembers() {
        return ResponseEntity.status(HttpStatus.OK).body(membroService.findAll());
    }

    @GetMapping("{id}") // GET MEMBER BY ID (READ)
    public ResponseEntity<Object> getOneMember(@PathVariable(value = "id") Integer id){
        Optional<MembroModel> membroModelOptional = membroService.findById(id);
        if(membroModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Membro não cadastrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(membroModelOptional.get());
    }

    @PostMapping // CREATE
    public ResponseEntity<Object> saveMember(@RequestBody @Valid MembroDto membroDto){
        if(membroService.existsByNome(membroDto.getNome())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome já está cadastrado");
        }
        int nucleoId = membroDto.getNucleo();
        NucleoModel nucleoModel = nucleoRepository.getById(nucleoId);

        var membroModel = new MembroModel();
        membroModel.registerNucleo(nucleoModel);

        BeanUtils.copyProperties(membroDto, membroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(membroService.save(membroModel));
    }

    @PutMapping("{id}") // UPDATE MEMBER BY ID
    public ResponseEntity<Object> updateMember(@PathVariable(value = "id") Integer id,
                                               @RequestBody @Valid MembroDto membroDto){
        Optional<MembroModel> membroModelOptional = membroService.findById(id);
        if (membroModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Membro Inexistente");
        }
        var membroModel = new MembroModel();
        BeanUtils.copyProperties(membroDto, membroModel);
        membroModel.setId(membroModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(membroService.save(membroModel));
    }

    @DeleteMapping("{id}") // DELETE MEMBER
    public ResponseEntity<Object> deleteMember(@PathVariable(value = "id") Integer id){
        Optional<MembroModel> membroModelOptional = membroService.findById(id);
        if (membroModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Membro Inexistente");
        }
        membroService.delete(membroModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Membro Deletado com Sucesso");
    }
}