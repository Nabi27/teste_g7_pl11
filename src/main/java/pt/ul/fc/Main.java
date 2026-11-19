package pt.ul.fc;

/**
 * Cliente de {@link AvaliacaoAluno}. NÃO ALTERE ESTE FICHEIRO (nem sequer espaços ou comentários):
 * a nota depende das linhas exatas deste ficheiro.
 * Cada sequenciaN() usa um objeto novo e termina com uma chamada que viola o protocolo.
 */
public class Main {

    public static void main(String[] args) {
        sequencia1();
        sequencia2();
        sequencia3();
        sequencia4();
    }


    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia1() {
        AvaliacaoAluno avaliacaoAluno = new AvaliacaoAluno();
        avaliacaoAluno.entregar();
        avaliacaoAluno.avaliar();
        avaliacaoAluno.pedirRevisao();
        avaliacaoAluno.pedirRevisao();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia2() {
        AvaliacaoAluno avaliacaoAluno = new AvaliacaoAluno();
        avaliacaoAluno.entregar();
        avaliacaoAluno.desistir();
        avaliacaoAluno.avaliar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia3() {
        AvaliacaoAluno avaliacaoAluno = new AvaliacaoAluno();
        avaliacaoAluno.entregar();
        avaliacaoAluno.avaliar();
        avaliacaoAluno.pedirRevisao();
        avaliacaoAluno.publicar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia4() {
        AvaliacaoAluno avaliacaoAluno = new AvaliacaoAluno();
        avaliacaoAluno.entregar();
        avaliacaoAluno.desistir();
        avaliacaoAluno.desistir();
    }
}
