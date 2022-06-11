package com.api.organograma.repositories;

import com.api.organograma.models.MembroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<MembroModel, Integer> {
    boolean existsByNome(String nome);
}
