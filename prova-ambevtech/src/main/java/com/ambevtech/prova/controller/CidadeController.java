package com.ambevtech.prova.controller;

import com.ambevtech.prova.dto.CidadeFrontDto;
import com.ambevtech.prova.dto.FiltroDTO;
import com.ambevtech.prova.dto.ValidMessages;
import com.ambevtech.prova.service.CidadeService;
import com.ambevtech.prova.exception.ServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cidade")
@Api("/cidade")
@CrossOrigin(value = "*")
public class CidadeController {

    private final CidadeService service;

    @Autowired
    public CidadeController(CidadeService service) {
        this.service = service;
    }

    @ApiOperation(value = "Listar cidades", response = CidadeFrontDto.class, notes = "Procura por uma cidade específica ou lista todas cadastradas")
    @PostMapping("/listar")
    public ResponseEntity<?> buscarCidadesCadastradas(@ApiParam(value = "Nome da cidade e valores da paginação") @RequestBody FiltroDTO<String> filtro) throws ServiceException {
        return ResponseEntity.ok(service.listarCidadesCadastradas(filtro));
    }

    @ApiOperation(value = "Salvar cidade", response = CidadeFrontDto.class, notes = "Salva ou altera a cidade informada")
    @PostMapping
    public ResponseEntity<?> salvarCidade(@Valid @ApiParam(value = "Parâmetros do cadastro da cidade") @RequestBody CidadeFrontDto dto, BindingResult bindingResult) throws ServiceException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ValidMessages.retornaMensagemErro(bindingResult));
        }
        return ResponseEntity.ok(service.salvarCidade(dto));
    }

    @ApiOperation(value = "Consultar Previsão do Tempo", response = String.class, notes = "Consultar a previsão do tempo de acordo com a Cidade informada")
    @GetMapping("/previsao")
    public ResponseEntity<?> consultarPrevisao(@ApiParam(value = "Nome da cidade") @RequestParam String nomeCidade) throws ServiceException {
        return ResponseEntity.ok(service.consultarPrevisao(nomeCidade));
    }

    @ApiOperation(value = "Buscar cidade pelo ID", response = String.class, notes = "Busca a cidade específica pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id) throws ServiceException {
        return ResponseEntity.ok(service.buscarCidadePorId(id));
    }
}
