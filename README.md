# Desafio Criando um Banco Digital com Java e Orientação a Objetos 👨🏽‍💻🚀☕

### Desafio de projeto para criar um banco digital utilizando a linguagem Java e o paradigma da Orientação a Objetos e seus pilares (Abstração, Encapsulamento, Herança e Polimorfismo).

### O projeto faz parte de um desafio do Bootcamp GFT Start5, ministrado pela plataforma Digital Innovation One.

### Para a criação do projeto, em relação ao original ministrado, acrescentei novos métodos, classes, pacote teste e suas classes e pacote exception e suas classes, a saber:

## Classe NumeroConta:
### A classe NumeroConta é a responsável por fazer a geração automática de número de conta. A criação do número se dá de forma aleatória, utilizando a classe Random, do pacote java.util.Random.
### O número aleatório gerado é informado diretamente no construtor da classe abstrata Conta, que implementa a interface ContaInterface. Assim, sempre que houver a instanciação de uma nova conta filha de Conta, um novo número aleatório, composto de 08 dígitos incluindo o "-", será gerado.
### O número da agência "0001" é uma constante de String, e o número completo da conta receberá a constante AGENCIA concatenado ao numero da conta gerado aleatoriamente, que é convertido em uma String.

## Classe TransferirException
### A classe TransferirException é a responsável por fazer o tratamento e a validação de transferências entre contas. 
### Para fazer a validação, a classe possui o método exceptionTransferir que implementa toda a lógica. Se o valor a trasferir for menor ou igual a zero, será lançada uma exceção TransferirException. Se o saldo da conta de origem for menor que o valor a ser transferido, também será lançada uma TransferirException. Por fim, caso a conta de destino for nula (null); será novamente lançada uma TransferirException. 
### O método exceptionTransferir é chamado no método transferir, das contas quando fizerem a transferência.

## Classe SaqueException
### Igualmente à classe TransferirException, a classe SaqueException é a responsável por fazer o tratamento e a validação de saques da conta que chamar o método sacar.
### Para fazer a validação, a classe possui o método exceptionSaque que implementa toda a lógica. Se o saldo da conta for menor ou igual a zero, será lançada a SaqueException informando a impossibilidade de sacar. 
### O saque possui em sua regra de negócio uma taxa de R$ 5.00/saque. Por isso, se o saldo da conta for menor que o valor a sacar + taxa de saque (R$ 5.00), será lançada a SaqueException informando a impossibilidade de se fazer o saque. 
### O método exceptionSaque é chamado no método sacar, das contas que fizerem o saque.
