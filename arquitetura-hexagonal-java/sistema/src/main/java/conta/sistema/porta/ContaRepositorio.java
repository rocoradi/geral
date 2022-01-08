package conta.sistema.porta;

import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.modelo.NegocioException;

// Responsável por definir a porta de saída (driven) de serviços de banco de dados.
public interface ContaRepositorio {

    Conta get(Integer numero);
    void alterar(Conta conta);
}
