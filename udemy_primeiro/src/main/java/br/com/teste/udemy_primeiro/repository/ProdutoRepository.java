package br.com.teste.udemy_primeiro.repository;

import br.com.teste.udemy_primeiro.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


}