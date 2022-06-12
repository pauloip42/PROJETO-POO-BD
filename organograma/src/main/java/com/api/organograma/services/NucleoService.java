package com.api.organograma.services;

import com.api.organograma.models.NucleoModel;
import com.api.organograma.repositories.NucleoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NucleoService {
    final NucleoRepository nucleoRepository;

    public NucleoService(NucleoRepository nucleoRepository) {
        this.nucleoRepository = nucleoRepository;
    }

    public List<NucleoModel> findAll() {
        return nucleoRepository.findAll();
    }

    public NucleoModel save(NucleoModel nucleoModel) {
        return nucleoRepository.save(nucleoModel);
    }
}
