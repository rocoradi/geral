package com.ambevtech.prova.repository;

import com.ambevtech.prova.dto.CidadeFrontDto;
import com.ambevtech.prova.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    @Query("select new com.ambevtech.prova.dto.CidadeFrontDto(" +
            "c.id, " +
            "c.nome, " +
            "c.uf ) " +
            "from Cidade c " +
            "where (:nome is null or c.nome like CONCAT('%', :nome, '%')) " +
            "order by c.nome ")
    Page<CidadeFrontDto> buscarCidadesCadastradas(String nome, Pageable pageable);

    Cidade findByNome(String nome);

    @Query("select new com.ambevtech.prova.dto.CidadeFrontDto(" +
            "c.id, " +
            "c.nome, " +
            "c.uf ) " +
            "from Cidade c " +
            "where c.id = :id " +
            "order by c.nome ")
    CidadeFrontDto findByIdCidade(@Param("id") Integer id);
}
