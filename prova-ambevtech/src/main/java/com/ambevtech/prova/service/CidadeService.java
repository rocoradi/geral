package com.ambevtech.prova.service;

import com.ambevtech.prova.config.CacheNames;
import com.ambevtech.prova.dto.CidadeFrontDto;
import com.ambevtech.prova.dto.FiltroDTO;
import com.ambevtech.prova.dto.previsao.PrevisaoDto;
import com.ambevtech.prova.entity.Cidade;
import com.ambevtech.prova.exception.EnumErrorException;
import com.ambevtech.prova.exception.ServiceException;
import com.ambevtech.prova.repository.CidadeRepository;
import com.ambevtech.prova.util.FunctionUtil;
import com.ambevtech.prova.util.MappingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class CidadeService {

    private Logger logger = LoggerFactory.getLogger(CidadeService.class);
    private final CidadeRepository repository;
    private final PrevisaoTempoService tempoService;

    @Autowired
    public CidadeService(CidadeRepository repository, PrevisaoTempoService tempoService) {
        this.repository = repository;
        this.tempoService = tempoService;
    }

    /**
     * @param dto - Dados da cidade para serem salvos
     * @return CidadeFrontDto
     * @throws ServiceException
     * @author Rodrigo Coradi
     * @method Método responsável por salvar a cidade
     */
    public CidadeFrontDto salvarCidade(CidadeFrontDto dto) throws ServiceException {
        logger.info("Início do processo de persistência da cidade...");
        validarDtoFront(dto);
        tempoService.validarCidade(dto.getNome());

        Cidade cidade = new Cidade();
        if (!FunctionUtil.isEmpty(dto.getId())) {
            cidade = buscarCidade(dto.getId());
            validarCidadeDuplicada(dto.getNome(), cidade);
        } else {
            validarNomeDuplicado(dto.getNome());
        }
        BeanUtils.copyProperties(dto, cidade, "id");
        salvar(cidade);
        return MappingUtil.map(cidade, CidadeFrontDto.class);
    }

    /**
     * @param filtro - Resposável por filtrar a busca da cidade
     * @return 'Page<CidadeFrontDto>' - Retorna um Page de CidadeFrontDto para listagem
     * @throws ServiceException
     * @author Rodrigo Coradi
     * @method Método responsável por listar as cidades cadastradas
     */
    public Page<CidadeFrontDto> listarCidadesCadastradas(FiltroDTO<String> filtro) throws ServiceException {
        logger.info("Buscando cidades cadastradas...");
        Page<CidadeFrontDto> lista = null;
        try {
            lista = repository.buscarCidadesCadastradas(filtro.getObj(), PageRequest.of(filtro.getPage(), filtro.getSize()));
        } catch (Exception e) {
            logger.error("Falha ao buscar cidades no banco de dados: " + e.getMessage());
            throw new ServiceException(EnumErrorException.ERRO_INTERNO, new Object[]{"Falha ao buscar cidades no banco de dados."});
        }
        return lista;
    }

    /**
     * @param nome - Nome da cidade
     * @return Previsao do Tempo
     * @throws ServiceException
     * @author Rodrigo Coradi
     * @method Método responsável por consultar a previsão do tempo
     */
    @Cacheable(value = CacheNames.cachePrevisao, key = "{#nome}")
    public PrevisaoDto consultarPrevisao(String nome) throws ServiceException {
        logger.info("Consultando previsão do tempo...");
        return tempoService.consultarPrevisao(nome);
    }

    /**
     * @param id - Id da Cidade
     * @return CidadeFrontDto
     * @throws ServiceException
     * @author Rodrigo Coradi
     * @method Método responsável por consultar uma cidade pelo ID
     */
    public CidadeFrontDto buscarCidadePorId(Integer id) throws ServiceException {
        if (FunctionUtil.isEmpty(id)) {
            throw new ServiceException(EnumErrorException.PARAMETROS_INVALIDOS, new Object[]{"ID da cidade deve ser informado"});
        }
        return repository.findByIdCidade(id);
    }

    private void validarNomeDuplicado(String nome) throws ServiceException {
        Cidade cidade = repository.findByNome(nome);
        if (!FunctionUtil.isNull(cidade)) {
            throw new ServiceException(EnumErrorException.DUPLICATE, new Object[]{"Cidade já cadastrada no banco de dados."});
        }
    }

    private void validarCidadeDuplicada(String nome, Cidade cidadeValidar) throws ServiceException {
        Cidade cidade = repository.findByNome(nome);

        if (!FunctionUtil.isNull(cidade)) {
            if (!cidade.getNome().equals(cidadeValidar.getNome())) {
                throw new ServiceException(EnumErrorException.DUPLICATE, new Object[]{"Cidade já cadastrada no banco de dados."});
            }
        }
    }

    private Cidade buscarCidade(Integer id) {
        return repository.findById(id).orElse(new Cidade());
    }

    private void validarDtoFront(CidadeFrontDto dto) throws ServiceException {
        logger.info("Validando DTO de cidade...");
        if (FunctionUtil.isNull(dto)) {
            throw new ServiceException(EnumErrorException.PARAMETROS_INVALIDOS, new Object[]{"Devem ser informados os valores para a Cidade."});
        }

        Set<ConstraintViolation<Object>> validacoes = FunctionUtil.validarEntidade(dto);
        if (!FunctionUtil.isEmpty(validacoes)) {
            throw new ServiceException(validacoes);
        }
    }

    private void salvar(Cidade cidade) throws ServiceException {
        logger.info("Salvando a cidade no banco de dados...");
        try {
            repository.save(cidade);
        } catch (Exception e) {
            logger.error("Falha ao persistir cidade no banco de dados: " + e.getMessage());
            throw new ServiceException(EnumErrorException.BAD_REQUEST, new Object[]{"Falha ao persistir cidade no banco de dados."});
        }
    }

}
