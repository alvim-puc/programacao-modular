# Cadastro de Pessoas 

## Requisitos

Implemente um sistema de cadastro de pessoas com os seguintes requisitos.

### Classe `Pessoa`

A classe `Pessoa` deve possuir os seguintes atributos:

- **nome**: `String`  
  - Apenas caracteres alfabéticos e espaços.
  
- **altura**: `float`  
  - Altura em metros, onde `0 < altura < 3`.
  
- **peso**: `float`  
  - Peso em quilos, onde `0 < peso < 500`.
  
- **dataNascimento**: `LocalDate`  
  - A data de nascimento deve ser anterior à data atual.
  
- **estadoCivil**: `enum EstadoCivil`  
  - Valores possíveis: `{SOLTEIRO, CASADO, UNIAO_ESTAVEL, DIVORCIADO, SEPARADO, VIUVO}`.
  
- **formacaoAcademica**: `enum FormacaoAcademica`  
  - Valores possíveis: `{NENHUMA, BASICA, MEDIA, SUPERIOR}`.
  
- **profissao**: `enum Profissao`  
  - Valores possíveis: `{DESEMPREGADO, ESTUDANTE, AUTONOMO, CLT, EMPRESARIO}`.
  
- **vidaSocial**: `boolean`  
  - Indica se a pessoa possui vida social.
  
- **hobby**: `boolean`  
  - Indica se a pessoa possui um hobby.
  
- **atividadeFisica**: `int`  
  - Representa quantos dias na semana a pessoa pratica atividade física, onde `0 <= atividadeFisica <= 7`.
  
- **saude**: `int`  
  - Representa o estado de saúde em uma escala de `1` a `10`.

### Implementação

As seguintes classes e arquivos devem ser implementados:

- **Classe `Pessoa`**:
  - Deve incluir os atributos mencionados acima.
  - Implementar **getters** e **setters** para todos os atributos.
  - Os **setters** devem validar os campos conforme os requisitos apresentados.

- **Tipos Enumerados (`enum`)**:
  - **EstadoCivil**, **FormacaoAcademica**, **Profissao**:
    - Devem ser públicos e estar em seus respectivos arquivos.

- **Classe `App`**:
  - Deve conter o método `main` que realiza o cadastro de pessoas.
  - O cadastro deve ser armazenado em um atributo público e estático da classe `App`, que é um vetor de `Pessoa`.

- **Classe `PessoaTest`**:
  - Deve testar todos os requisitos implementados nos **setters**.

### Estrutura de Pacotes

- **Pacote `business`**:
  - Classe `Pessoa`.
  - Tipos enumerados (`enum`): **EstadoCivil**, **FormacaoAcademica**, **Profissao**.
  
- **Pacote `main`**:
  - Classe `App`.
  
- **Pacote `test`**:
  - Classe `PessoaTest`.

--- 