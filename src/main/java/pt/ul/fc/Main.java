package pt.ul.fc;

/**
 * Cliente de {@link Porta}. NÃO ALTERE ESTE FICHEIRO (nem sequer espaços ou comentários):
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
        Porta porta = new Porta();
        porta.destrancar();
        porta.trancar();
        porta.fechar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia2() {
        Porta porta = new Porta();
        porta.arrombar();
        porta.arrombar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia3() {
        Porta porta = new Porta();
        porta.abrir();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia4() {
        Porta porta = new Porta();
        porta.arrombar();
        porta.trancar();
    }
}
