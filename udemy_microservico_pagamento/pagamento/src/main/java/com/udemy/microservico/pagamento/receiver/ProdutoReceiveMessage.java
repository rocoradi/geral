package com.udemy.microservico.pagamento.receiver;

import com.udemy.microservico.pagamento.data.vo.ProdutoVO;
import com.udemy.microservico.pagamento.entity.Produto;
import com.udemy.microservico.pagamento.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProdutoReceiveMessage {

    private final ProdutoRepository produtoRepository;

    @Value("${pagamento.rabbitmq.queue}")
    String fila;

    @Autowired
    public ProdutoReceiveMessage(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @RabbitListener(queues = {"${pagamento.rabbitmq.queue}"})
    public void receive(@Payload ProdutoVO produtoVO) {
        log.info("Pegou da fila: " + fila);
        produtoRepository.save(Produto.create(produtoVO));
    }
}
