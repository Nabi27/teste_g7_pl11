# Ramo `64987`: Rever e integrar um pedido de integração (pull request)

Este ramo é só seu. Contém um pequeno projeto Java 21 / Maven que usa o LiquidJava.

> **Não altere o `Main.java`** (nem sequer espaços ou comentários) **nem a pasta `.github/`.**
> A nota é calculada exclusivamente a partir do registo da GitHub Action *Análise estática
> LiquidJava* do seu PR, que depende das linhas exatas do `Main.java`. Um PR que altere um destes
> ficheiros tem 0 pontos neste exercício.

## A máquina de estados

Um pedido de integração começa como rascunho. Depois de pedida a revisão pode ser aprovado; se forem pedidas alterações (durante a revisão ou depois da aprovação) volta a rascunho. Só um pedido aprovado pode ser integrado, e um rascunho ou um pedido em revisão pode ser fechado sem integração.

Em `src/main/java/pt/ul/fc/PedidoIntegracao.java` está a classe `PedidoIntegracao`, anotada com `@StateSet` com os estados abaixo.

- `rascunho`: rascunho
- `emRevisao`: em revisão
- `aprovado`: aprovado
- `integrado`: integrado
- `fechado`: fechado sem integração

O protocolo da classe (a *única* fonte de verdade) é este:

| Método | Estado de origem permitido | Estado de destino | O que faz |
|---|---|---|---|
| Construtor `PedidoIntegracao()` | — | `rascunho` | Cria o objeto. |
| `pedirRevisao()` | `rascunho` | `emRevisao` | Pede revisão do rascunho. |
| `aprovar()` | `emRevisao` | `aprovado` | Aprova o pedido. |
| `pedirAlteracoes()` | `emRevisao` ou `aprovado` | `rascunho` | Pede alterações; volta a rascunho. |
| `integrar()` | `aprovado` | `integrado` | Integra o pedido (definitivo). |
| `encerrar()` | `rascunho` ou `emRevisao` | `fechado` | Fecha o pedido sem o integrar (definitivo). |

![Máquina de estados de PedidoIntegracao](assets/maquina_estados.png)

O estado inicial é `rascunho`. Um método só pode ser chamado nos estados de origem indicados
e, depois de terminar, o objeto fica no estado de destino.

## O que fazer

1. Abra `src/main/java/pt/ul/fc/PedidoIntegracao.java`. O método `pedirRevisao()` já tem o seu contrato
   (`from="rascunho()", to="emRevisao()"`): serve de exemplo. Os restantes 4 métodos têm
   `@StateRefinement(from="true", to="true")`, que não especifica nada. Preencha, em cada um deles, o `from`
   e o `to` do quadro.
2. Em `src/main/java/pt/ul/fc/Main.java`, os métodos
   `sequencia1()` a `sequencia4()` terminam todos com uma chamada **inválida**, uma por cada método
   que tem de especificar. **Não altere o `Main.java`**: o `main` tem de continuar a chamar os
   métodos da forma errada.
3. Com o ficheiro guardado, confirme no VS Code (extensão LiquidJava) que cada uma das 4 sequências
   inválidas tem **um erro** na última chamada.
4. Não remova o `@StateSet`, não use supressões e não mude as assinaturas dos métodos.
5. Faça *commit* e *push* do seu ramo: `git push origin 64987`.
6. Abra um PR para o repositório original, com o ramo `64987` como destino.

Quando o seu trabalho estiver correto, a GitHub Action **Análise estática LiquidJava** do PR
**falha**: é o resultado esperado, porque o `Main` viola de propósito o protocolo.
Se a Action passar, os seus contratos estão demasiado permissivos.

A nota é dada pelo número de sequências inválidas que o LiquidJava rejeita no registo dessa
Action (até 4 pontos, um por cada método especificado). Confirme no separador *Checks* do PR que a
Action correu.

Use mensagens de *commit* com significado.

## Comandos úteis

```
java -version                 # deve ser JDK 21
mvn -version                  # Maven 3.9 ou superior, com JDK 21
mvn clean compile             # só compila o Java; a verificação LiquidJava é feita pela extensão
git fetch origin
git checkout 64987
git add -A
git commit -m "Mensagem"
git push origin 64987
./setup.sh "Nome" "email"     # configura o git (se ainda não o fez)
```

`mvn compile` não executa o LiquidJava: um projeto que compila pode ter erros de refinamento.
