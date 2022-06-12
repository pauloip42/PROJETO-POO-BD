package com.api.organograma.repositories;

import com.api.organograma.models.MembroModel;
import com.api.organograma.models.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NucleoRepository extends JpaRepository<NucleoModel, Integer> {
    boolean existsByNome(String nome);

}
