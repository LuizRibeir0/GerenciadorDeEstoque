package com.docevida.GerenciadorDeEstoque.repository;

import com.docevida.GerenciadorDeEstoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
