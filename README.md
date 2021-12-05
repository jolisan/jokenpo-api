# jokenpo-api

## Resumo 📖
Este projeto consiste na resolução do problema [Jokenpo](https://dojopuzzles.com/problems/jokenpo/) presente no DojoPuzzles, atráves do desenvolvimento de uma REST API com Spring Boot.

## Pré-requisitos ❗
Para utilizar a API é necessário ter as seguintes tecnologias instaladas no seu S.O:

| Requisitos | Versão recomendada  | 
| ------- | --- |
| [Java JDK](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) | 11.0.12 |
| [Spring Tool Suite *](https://spring.io/tools) | 4.12.1 |
| [Eclipse IDE *](https://www.eclipse.org/downloads/) | 2021-09 |

Os requisitos com " <b>*</b> " são opcionais, e devem ser utilizados caso seja necessário rodar a aplicação utilizando uma IDE em ambiente Linux/Windows.

## Instruções para execução da solução 🟢
Após instalar os pré-requisitos necessários, devemos nos certificar que está tudo ok para rodarmos a aplicação:

1 - Execute o shell/prompt: 
* ```javac --version```
* Caso seja retornado "javac 11.0.12", está tudo ok e podemos seguir com a execução da aplicação.
* Caso contrário, volte ao passo de pré-requisitos e instale o Java JDK 11.0.12.

2 - Vá até o diretório do projeto
* ```cd jokenpo-api```

3 - Acesse o diretório target
* ```cd target```

4 - Execute o seguinte comando:
* ```java -jar jokenpo-api-0.0.1-SNAPSHOT.jar```
* Através desse comando, você estará executando o projeto Maven empacotado, este arquivo é chamado de "Fetch JAR", e contém todas as dependências necessárias para executar a aplicação.
* Essa solução é geralmente utilizada quando queremos executar um projeto facilmente, sem utilizar uma IDE.

5 - Pronto! Se você seguiu todos os passos corretamente, a aplicação já está rodando e nos próximos passos você poderá utilizar a API.

## Utilizando a API ✅

### Rota 🎯
Para utilizar a API e realizar uma jogada do Jokenpo, utilize a rota [/api/jokenpo/play](), passando os parâmetros necessários como será especificado abaixo:

[http://localhost:8080/api/jokenpo/play?player1=PEDRA&player2=PAPEL]()

Ou seja, onde o parâmetro "player1" corresponde a escolha do Jogador 1, e "player2" a escolha do "Jogador 2" respectivamente.

Outros exemplos:
* [http://localhost:8080/api/jokenpo/play?player1=TESOURA&player2=PAPEL]()
* [http://localhost:8080/api/jokenpo/play?player1=PEDRA&player2=PEDRA]()

A resposta para cada requisição feita a API demonstrada acima, teria como resposta em JSON, respectivamente:

<b>Exemplo 1 -</b> Com vitória do Jogador 2 que escolheu PAPEL:
```
{
   "PEDRA":"Player 1",
   "PAPEL":"Player 2",
   "WINNER":"Player 2"
}
```
<b>Exemplo 2 -</b> Com vitória do Jogador 1 que escolheu TESOURA:
```
{
   "PAPEL":"Player 2",
   "TESOURA":"Player 1",
   "WINNER":"Player 1"
}
```
<b>Exemplo 3 -</b> Com empate, pois ambos os Jogadores escolheram a mesma opção:
```
{
   "WINNER":"DRAW"
}
```

E em caso de erro, ou passagem de parâmetro(jogada) inválida, será apresentado um:
```BAD_REQUEST```

## Testes 🔎
Os testes foram realizados com o framework [JUnit](https://junit.org/junit5/), onde os casos de testes utilizados são os seguintes:

![alt tag](https://i.imgur.com/X2GVz1l.png)
* <b> mustReturnSuccess_WhenPlay_Pedra_Tesoura() -</b> Ao passar os parâmetros PEDRA e TESOURA, para os Jogadores 1 e 2 respectivamente, verifica se houve sucesso ao efetuar a jogada e retornar o vencedor;

* <b> mustReturnSuccess_WhenPlay_Tesoura_Papel() -</b> Ao passar os parâmetros TESOURA e PAPEL, para os Jogadores 1 e 2 respectivamente, verifica se houve sucesso ao efetuar a jogada e retornar o vencedor;

* <b> mustReturnSuccess_WhenPlay_Papel_Pedra() -</b> Ao passar os parâmetros PAPEL e PEDRA, para os Jogadores 1 e 2 respectivamente, verifica se houve sucesso ao efetuar a jogada e retornar o vencedor;

* <b> mustReturnSuccess_WhenPlay_WithSameParameters_Draw() -</b> Ao passar os parâmetros de jogada <b>IGUAIS</b> para ambos os jogadores, verifica se a resposta do jogo foi EMPATE(DRAW);

* <b> mustReturnWinner_ToPlayer1_WhenPlay_Pedra_Tesoura() -</b> Ao passar os parâmetros de jogada PEDRA e TESOURA, para os Jogadores 1 e 2 respectivamente, segundo as regras do jogo, o Jogador 1 deve vencer, portanto, verifica se a resposta do jogo foi <b>VITÓRIA</b> para o Jogador 1;

* <b> mustReturnBadRequest_WhenPlay_WithInvalidParameters() -</b> Ao passar parâmetros inválidos, retorna ```BAD_REQUEST```, pois a jogada não é possível.
