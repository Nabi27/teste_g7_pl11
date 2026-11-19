# Ramo `65588`: Entregar uma encomenda

Este ramo é só seu. Contém um pequeno projeto Java 21 / Maven que usa o LiquidJava.

> **Não altere o `Main.java`** (nem sequer espaços ou comentários) **nem a pasta `.github/`.**
> A nota é calculada exclusivamente a partir do registo da GitHub Action *Análise estática
> LiquidJava* do seu PR, que depende das linhas exatas do `Main.java`. Um PR que altere um destes
> ficheiros tem 0 pontos neste exercício.

## A máquina de estados

Uma encomenda é criada, expedida e entregue. Se o destinatário a recusar, é devolvida ao armazém e pode voltar a ser preparada. Uma encomenda entregue ou devolvida pode ser arquivada.

Em `src/main/java/pt/ul/fc/Encomenda.java` está a classe `Encomenda`, anotada com `@StateSet` com os estados abaixo.

- `criada`: criada, no armazém
- `expedida`: expedida
- `entregue`: entregue
- `devolvida`: devolvida
- `arquivada`: arquivada

O protocolo da classe (a *única* fonte de verdade) é este:

| Método | Estado de origem permitido | Estado de destino | O que faz |
|---|---|---|---|
| Construtor `Encomenda()` | — | `criada` | Cria o objeto. |
| `expedir()` | `criada` | `expedida` | Expede a encomenda. |
| `entregar()` | `expedida` | `entregue` | Entrega a encomenda ao destinatário. |
| `recusar()` | `expedida` | `devolvida` | O destinatário recusa a encomenda; é devolvida. |
| `repor()` | `devolvida` | `criada` | Volta a preparar a encomenda devolvida. |
| `arquivar()` | `entregue` ou `devolvida` | `arquivada` | Arquiva a encomenda (definitivo). |

![Máquina de estados de Encomenda](assets/maquina_estados.png)

O estado inicial é `criada`. Um método só pode ser chamado nos estados de origem indicados
e, depois de terminar, o objeto fica no estado de destino.

## O que fazer

1. Abra `src/main/java/pt/ul/fc/Encomenda.java`. O método `expedir()` já tem o seu contrato
   (`from="criada()", to="expedida()"`): serve de exemplo. Os restantes 4 métodos têm
   `@StateRefinement(from="true", to="true")`, que não especifica nada. Preencha, em cada um deles, o `from`
   e o `to` do quadro.
2. Em `src/main/java/pt/ul/fc/Main.java`, os métodos
   `sequencia1()` a `sequencia4()` terminam todos com uma chamada **inválida**, uma por cada método
   que tem de especificar. **Não altere o `Main.java`**: o `main` tem de continuar a chamar os
   métodos da forma errada.
3. Com o ficheiro guardado, confirme no VS Code (extensão LiquidJava) que cada uma das 4 sequências
   inválidas tem **um erro** na última chamada.
4. Não remova o `@StateSet`, não use supressões e não mude as assinaturas dos métodos.
5. Faça *commit* e *push* do seu ramo: `git push origin 65588`.
6. Abra um PR para o repositório original, com o ramo `65588` como destino.

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
git checkout 65588
git add -A
git commit -m "Mensagem"
git push origin 65588
./setup.sh "Nome" "email"     # configura o git (se ainda não o fez)
```

`mvn compile` não executa o LiquidJava: um projeto que compila pode ter erros de refinamento.
