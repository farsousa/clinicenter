# CliniCenter
Este projeto é uma API REST em Spring Boot para gerenciar consultas médicas.

## Requisitos

### R1 - O sistema deve possuir uma funcionalidade de cadastro de médicos, na qual as seguintes informações deverão ser preenchidas:
* Nome
* E-mail
* Telefone
* CRM
* Especialidade
* Endereço (logradouro, número, complemento, bairro, cidade, UF)

Todas as informações são de preenchimento obrigatório, exceto o complemento do endereço.

### R2 - O sistema deve possuir uma funcionalidade de listagem de médicos, na qual as informações, de cada um dos médicos cadastrados, deverão ser exibidas:

A listagem deve ser ordenada pelo nome do médico, de maneira crescente, bem como ser paginada, trazendo 10 registros por página.

### R3 - O sistema deve possuir uma funcionalidade de atualização de dados cadastrais de médicos, na qual as seguintes informações poderão ser atualizadas:
* Nome
* Telefone
* Endereço

As seguintes regras de negócio devem ser validadas pelo sistema:
* Não permitir a alteração do e-mail do médico;
* Não permitir a alteração do CRM do médico;
* Não permitir a alteração da Especialidade do médico.

### R4 - O sistema deve possuir uma funcionalidade que permita a exclusão de médicos cadastrados.

As seguintes regras de negócio devem ser validadas pelo sistema:
* A exclusão não deve apagar os dados do médico, mas torná-lo como "inativo" no sistema.

### R5 - O sistema deve possuir uma funcionalidade de cadastro de pacientes, na qual as seguintes informações deverão ser preenchidas:
* Nome
* E-mail
* Telefone
* CPF
* Endereço (logradouro, número, complemento, bairro, cidade, UF)

Todas as informações são de preenchimento obrigatório, exceto o complemento do endereço.

### R6 - O sistema deve possuir uma funcionalidade de listagem de pacientes, na qual as informações, de cada um dos pacientes cadastrados, deverão ser exibidas:

A listagem deve ser ordenada pelo nome do paciente, de maneira crescente, bem como ser paginada, trazendo 10 registros por página. E na listagem individual deve ser apresentada todas as suas consultas. 

### R7 - O sistema deve possuir uma funcionalidade de atualização de dados cadastrais de pacientes, na qual as seguintes informações poderão ser atualizadas:
* Nome
* Telefone
* Endereço

As seguintes regras de negócio devem ser validadas pelo sistema:
* Não permitir a alteração do e-mail do paciente;
* Não permitir a alteração do CPF do paciente.

### R8 - O sistema deve possuir uma funcionalidade que permita a exclusão de pacientes cadastrados.

As seguintes regras de negócio devem ser validadas pelo sistema:
* A exclusão não deve apagar os dados do paciente, mas torná-lo como "inativo" no sistema.

### R9 - O sistema deve possuir uma funcionalidade que permita o registro de consultas, na qual as seguintes informações deverão ser preenchidas:
* Paciente
* Médico
* Data/Hora da consulta
* Observação

As seguintes regras de negócio devem ser validadas pelo sistema:
* O horário de funcionamento da clínica é de segunda a sábado, das 07:00 às 19:00;
* As consultas tem duração fixa de 30 min;
* Não permitir o registro de consultas com pacientes inativos no sistema;
* Não permitir o registro de consultas com médicos inativos no sistema;
* Não permitir o registro de mais de uma consulta no mesmo dia para um mesmo paciente;
* Não permitir o registro de uma consulta com um médico que já possui outra consulta registrada nos limites da duração fixa;

### R10 - O sistema deve possuir uma funcionalidade que permita a listagem geral de consultas, apresentando as seguintes informações:
* Horário
* Paciente

A listagem deve ser ordenada pela data da consulta e deve haver um filtro por médico (obrigatório) e data (opcional). Já a listagem individual deve apresentar todos os dados.

