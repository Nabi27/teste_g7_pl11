package pt.ul.fc;

/**
 * Cliente de {@link Encomenda}. NÃO ALTERE ESTE FICHEIRO (nem sequer espaços ou comentários):
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
        Encomenda encomenda = new Encomenda();
        encomenda.expedir();
        encomenda.entregar();
        encomenda.repor();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia2() {
        Encomenda encomenda = new Encomenda();
        encomenda.expedir();
        encomenda.recusar();
        encomenda.arquivar();
        encomenda.entregar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia3() {
        Encomenda encomenda = new Encomenda();
        encomenda.expedir();
        encomenda.recusar();
        encomenda.repor();
        encomenda.recusar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia4() {
        Encomenda encomenda = new Encomenda();
        encomenda.expedir();
        encomenda.entregar();
        encomenda.arquivar();
        encomenda.arquivar();
    }
}
