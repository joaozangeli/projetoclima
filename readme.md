## Introdução

O ClimaWeb tem como objetivo trazer a temperatura e a condição climática de forma rápida e acessível

## 1. Configurações

### Requisitos

O aplicativo pode ser executado em configurações básicas de hardware pois não desempenha tarefas muito complexas que o sobrecarreguem.

Processador: Intel Pentium Dual Core

Memória: 2GB DDR3

Sistema operacional: 32bits ou superior

## 2. Biblioteca
Usamos Retrofit para converter o JSON recebido pela API no nosso objeto java.

## 3. Banco de dados
O banco de dados utilizado para salvar os dados na aplicação web foi o H2.

## 4. Api
Utilizamos a Api da HGBrasil, a HG Weather, que nos deu o objeto usado na aplicação.

## 5. Procedimentos

Ao acessar o site, o usuário recebe a informação da temperatura em graus Celsius, a descrição da condição climática e uma imagem de fundo correspondente com tal condição.

## 6. Relatório de incidências.

**Incidência 1: none_day**
Caso a condição climática do dia não seja encontrada, essa condição é acessada e exibe sua mensagem de erro.

**Incidência 2: none_night**
Caso a condição climática da noite não seja encontrada, essa condição é acessada e exibe sua mensagem de erro.

**Incidência 3: default**
Caso nenhuma condição climática seja encontrada, essa condição é acessada e exibe sua mensagem de erro.
### 6.1 Mensagens de erro.
•	“Erro ao obter condição do dia” caso acesse condição none_day.
•	“Erro ao obter condição da noite” caso acesse condição none_night.
•	“Condição não encontrada” caso acesse condição default.


## 7. Algumas capturas de telas







## 8. instalação

**Clone the repository**
git clone https://github.com/joaozangeli/projetoclima

** Enter repo folder**
cd projetoclima

## 9. Licenças
O ClimaWeb é uma aplicação de software livre, ou seja, seu código pode ser lido, copiado e modificado com fins lucrativos ou não.

## 10. Apoio, suporte
**Nota:** Antes de relatar um erro, por favor, olhe primeiro para uma solução no item 3. “Relatório de incidentes” deste documento.

Para obter assistência ou relatar um erro, por favor, entre em contato com:

**Help Desk**

Telefone: (27) 988063886