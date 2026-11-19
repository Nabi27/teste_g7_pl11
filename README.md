# Ramo `65592`: Emprestar um livro da biblioteca

Este ramo é só seu. Contém um pequeno projeto Java 21 / Maven que usa o LiquidJava.

> **Não altere o `Main.java`** (nem sequer espaços ou comentários) **nem a pasta `.github/`.**
> A nota é calculada exclusivamente a partir do registo da GitHub Action *Análise estática
> LiquidJava* do seu PR, que depende das linhas exatas do `Main.java`. Um PR que altere um destes
> ficheiros tem 0 pontos neste exercício.

## A máquina de estados

Um livro disponível pode ser requisitado. Enquanto requisitado pode ser renovado (continua requisitado) ou ser marcado como atrasado. Só se pode devolver um livro requisitado ou em atraso; um livro em atraso pode ainda ser dado como perdido.

Em `src/main/java/pt/ul/fc/EmprestimoLivro.java` está a classe `EmprestimoLivro`, anotada com `@StateSet` com os estados abaixo.

- `disponivel`: disponível
- `requisitado`: requisitado
- `atrasado`: requisitado e em atraso
- `perdido`: perdido

O protocolo da classe (a *única* fonte de verdade) é este:

| Método | Estado de origem permitido | Estado de destino | O que faz |
|---|---|---|---|
| Construtor `EmprestimoLivro()` | — | `disponivel` | Cria o objeto. |
| `requisitar()` | `disponivel` | `requisitado` | Requisita o livro. |
| `renovar()` | `requisitado` | `requisitado` | Renova o empréstimo (o livro continua requisitado). |
| `marcarAtraso()` | `requisitado` | `atrasado` | Marca o empréstimo como atrasado. |
| `devolver()` | `requisitado` ou `atrasado` | `disponivel` | Devolve o livro à biblioteca. |
| `declararPerdido()` | `atrasado` | `perdido` | Dá o livro como perdido (definitivo). |

![Máquina de estados de EmprestimoLivro](assets/maquina_estados.png)

O estado inicial é `disponivel`. Um método só pode ser chamado nos estados de origem indicados
e, depois de terminar, o objeto fica no estado de destino.

## O que fazer

1. Abra `src/main/java/pt/ul/fc/EmprestimoLivro.java`. O método `requisitar()` já tem o seu contrato
   (`from="disponivel()", to="requisitado()"`): serve de exemplo. Os restantes 4 métodos têm
   `@StateRefinement(from="true", to="true")`, que não especifica nada. Preencha, em cada um deles, o `from`
   e o `to` do quadro.
2. Em `src/main/java/pt/ul/fc/Main.java`, os métodos
   `sequencia1()` a `sequencia4()` terminam todos com uma chamada **inválida**, uma por cada método
   que tem de especificar. **Não altere o `Main.java`**: o `main` tem de continuar a chamar os
   métodos da forma errada.
3. Com o ficheiro guardado, confirme no VS Code (extensão LiquidJava) que cada uma das 4 sequências
   inválidas tem **um erro** na última chamada.
4. Não remova o `@StateSet`, não use supressões e não mude as assinaturas dos métodos.
5. Faça *commit* e *push* do seu ramo: `git push origin 65592`.
6. Abra um PR para o repositório original, com o ramo `65592` como destino.

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
git checkout 65592
git add -A
git commit -m "Mensagem"
git push origin 65592
./setup.sh "Nome" "email"     # configura o git (se ainda não o fez)
```

`mvn compile` não executa o LiquidJava: um projeto que compila pode ter erros de refinamento.
