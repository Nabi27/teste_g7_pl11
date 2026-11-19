# PES - LiquidJava: máquinas de estados

Neste repositório há um ramo com o seu número de estudante (ao fazer *fork*, garanta que
copia **todos** os ramos e não apenas o `main`). Nele encontra um pequeno projeto Java que
modela uma **máquina de estados** (descrita num quadro e num diagrama) e um `Main` que a usa
de forma incorreta. O seu trabalho é

1. escrever os 4 refinamentos `@StateRefinement` que estão por especificar, estabelecendo o
   contrato da classe (um quinto já vem preenchido, como exemplo),
2. confirmar com o LiquidJava que as sequências inválidas do `Main` são rejeitadas,
3. fazer *commit* e *push* para o seu ramo,
4. abrir um PR para o repositório original (com o seu ramo como destino).

**Não altere o `Main.java`** (nem sequer espaços ou comentários) **nem a pasta `.github/`**. A nota
é calculada exclusivamente a partir do registo da GitHub Action *Análise estática LiquidJava* que
corre no seu PR, e que depende das linhas exatas do `Main.java`. Um PR que altere estes ficheiros
tem 0 pontos neste exercício.

Requisitos: JDK 21, Maven 3.9+, git, VS Code com a extensão LiquidJava. Não faça *push* para
o `main` nem para outros ramos.

Leia com atenção o README do seu ramo.

Antes de começar, confirme que:

1. Tem sessão iniciada no GitHub,
2. Tem um Personal Access Token,
3. Configurou o seu nome e email neste computador (pode usar o script `setup.sh`; execute-o
   sem argumentos para ver como se usa).

Para mudar para o seu ramo:

```
git fetch origin
git checkout <o-seu-numero-de-estudante>
```

Bom trabalho!
