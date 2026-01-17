# Gestão de Veículos - API de Inteligência Patrimonial

API desenvolvida em **Java com Spring Boot** para gerenciamento de frota pessoal e análise de evolução patrimonial. O sistema não apenas cadastra veículos, mas monitora automaticamente a depreciação de mercado (via Tabela FIPE) comparando com indicadores econômicos reais (IPCA e CDI) para gerar insights financeiros.

## Funcionalidades Principais

* **Gestão de Veiculos:** CRUD completo de veículos vinculados a usuários.


* **Carga Histórica Assíncrona:** Ao cadastrar um veículo, o sistema dispara uma thread em background (@Async) que busca automaticamente até 30 anos de histórico de preço na FIPE via BrasilAPI, sem impactar o tempo de resposta do cadastro.


* **Inteligência Financeira:** Monitoramento mensal automático de indicadores econômicos (**IPCA** e **CDI**) integrados diretamente com o **Banco Central do Brasil (BACEN)**.


* **Histórico de Preços:** Versionamento mensal do valor do veículo para geração de gráficos de depreciação.


* **Agendamento Automático:** Rotinas (Schedulers) que rodam todo dia 1º do mês para atualizar a base de dados.


* **Segurança:** Autenticação e Autorização via **Spring Security** e **JWT**.

## Stack Tecnológica

* **Linguagem:** Java 17+
* **Framework:** Spring Boot 3 (Web, Data JPA, Security, Validation)
* **Banco de Dados:** MySQL
* **Comunicação Externa:** Spring Cloud OpenFeign
* **Agendamento:** Spring Scheduling
* **Build:** Maven

## Integrações Externas

O sistema consome dados de duas fontes públicas principais:

1. **FIPE API:** Utilizada para a consulta de metadados (Listagem de Marcas, Modelos e Anos)
2. **BrasilAPI:** Utilizada para busca de preços, detalhes profundos e carga histórica massiva.
3. **BCB (Banco Central) API:**
    * *Série 433:* IPCA (Inflação Mensal).
    * *Série 4389:* CDI Anual (Convertido matematicamente para taxa mensal equivalente via juros compostos).

## Como Rodar

### Pré-requisitos
* Java 17 ou superior
* MySQL rodando na porta 3306
* Maven

### Configuração
1. Clone o repositório.
2. Configure as variáveis de ambiente ou altere o arquivo `application.yml` com suas credenciais do banco de dados:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/gestaoveiculo
    username: seu_usuario
    password: sua_senha

api:
  security:
    token:
      secret: sua_secret
      expiration: sua_expiration
```
3. Execute a aplicação

```cmd
mvn spring-boot:run
```

### Destaques de Arquitetura

* Processamento Assíncrono: Uso de Threads gerenciadas pelo Spring para tarefas pesadas (carga de histórico).


* Tratamento de Erros: Exceções personalizadas.


* SOLID: Separação clara de responsabilidades entre Controllers, Services e Repositories.


* Matemática Financeira: Cálculo de taxas equivalentes (Anual -> Mensal) utilizando juros compostos para o CDI.


* Logs Padronizados: Rastreabilidade clara de início, fim e ação de cada método nos Services e Controllers.
