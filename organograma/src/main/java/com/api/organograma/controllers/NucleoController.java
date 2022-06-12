package com.api.organograma.controllers;

import com.api.organograma.dtos.NucleoDto;
import com.api.organograma.models.NucleoModel;
import com.api.organograma.services.NucleoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/nucleos")

public class NucleoController {
    final NucleoService nucleoService;

    public NucleoController(NucleoService nucleoService) {
        this.nucleoService = nucleoService;
    }

    @GetMapping // GET ALL MEMBERS (READ)
    public ResponseEntity<List<NucleoModel>> getAllNucleos() {
        return ResponseEntity.status(HttpStatus.OK).body(nucleoService.findAll());
    }

    @PostMapping // CREATE
    public ResponseEntity<Object> saveProject(@RequestBody @Valid NucleoDto nucleoDto){
        var nucleoModel = new NucleoModel();

        BeanUtils.copyProperties(nucleoDto, nucleoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(nucleoService.save(nucleoModel));
    }
}
