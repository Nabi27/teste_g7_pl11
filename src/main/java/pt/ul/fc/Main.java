package pt.ul.fc;

/**
 * Cliente de {@link Garrafa}. NÃO ALTERE ESTE FICHEIRO (nem sequer espaços ou comentários):
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
        Garrafa garrafa = new Garrafa();
        garrafa.endireitar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia2() {
        Garrafa garrafa = new Garrafa();
        garrafa.esvaziar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia3() {
        Garrafa garrafa = new Garrafa();
        garrafa.abrir();
        garrafa.tapar();
        garrafa.inclinar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia4() {
        Garrafa garrafa = new Garrafa();
        garrafa.abrir();
        garrafa.tapar();
        garrafa.tapar();
    }
}
