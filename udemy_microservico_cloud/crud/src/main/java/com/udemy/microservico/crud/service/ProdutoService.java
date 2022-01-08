package com.udemy.microservico.crud.service;

import com.udemy.microservico.crud.data.vo.ProdutoVO;
import com.udemy.microservico.crud.entity.Produto;
import com.udemy.microservico.crud.exception.ResourceNotFoundException;
import com.udemy.microservico.crud.message.ProdutoSendMessage;
import com.udemy.microservico.crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoSendMessage produtoSendMessage;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, ProdutoSendMessage produtoSendMessage) {
        this.produtoRepository = produtoRepository;
        this.produtoSendMessage = produtoSendMessage;
    }

    public ProdutoVO create(ProdutoVO produtoVO) {
        ProdutoVO retorno = ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
        produtoSendMessage.sendMessage(retorno);
        return retorno;
    }

    public Page<ProdutoVO> findAll(Pageable pageable) {
        var page = produtoRepository.findAll(pageable);
        return page.map(this::convertToProdutoVO);
    }

    public ProdutoVO findById(Long id) {
        var entity = produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não " +
                "encontrado"));
        return ProdutoVO.create(entity);
    }

    public ProdutoVO update(ProdutoVO produtoVO) {
        final Optional<Produto> optionalProduto = produtoRepository.findById(produtoVO.getId());

        if (!optionalProduto.isPresent()) {
            throw new ResourceNotFoundException("Produto não encontrado.");
        }

        return ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
    }

    public void delete(Long id) {
        var entity = produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não " +
                "encontrado"));

        produtoRepository.delete(entity);
    }

    private ProdutoVO convertToProdutoVO(Produto produto) {
        return ProdutoVO.create(produto);
    }
}
