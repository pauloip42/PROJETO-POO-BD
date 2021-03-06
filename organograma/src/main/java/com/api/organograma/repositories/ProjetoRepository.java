package com.api.organograma.repositories;

import com.api.organograma.models.MembroModel;
import com.api.organograma.models.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoModel, Integer> {
    boolean existsByNome(String nome);
    boolean existsByIdAndMembro(Integer id, MembroModel membro);
}
