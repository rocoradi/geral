#language: pt

  Funcionalidade: Salvar uma cidade

    Como aplicação eu preciso salvar a cidade.

    Esquema do Cenario: Salvar a cidade
      Dado que possuo uma cidade para salvar "<nomeCidade>" "<uf>"
      Quando confirmar o registro
      Então deve me retornar um status de "<status>"

      Exemplos:
      | nomeCidade | uf |  status |
      | Assis      | SP |  200    |
      | São Paulo  | SP |  200    |
      |            | SP |  400    |
      | Sorocaba   |    |  400    |
      | Rio Preto  | SP |  409    |
      | adadgada   | SP |  400    |



