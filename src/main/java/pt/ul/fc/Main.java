package pt.ul.fc;

/**
 * Cliente de {@link RefeicaoCongelada}. NÃO ALTERE ESTE FICHEIRO (nem sequer espaços ou comentários):
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
        RefeicaoCongelada refeicaoCongelada = new RefeicaoCongelada();
        refeicaoCongelada.deitarFora();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia2() {
        RefeicaoCongelada refeicaoCongelada = new RefeicaoCongelada();
        refeicaoCongelada.descongelar();
        refeicaoCongelada.voltarACongelar();
        refeicaoCongelada.voltarACongelar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia3() {
        RefeicaoCongelada refeicaoCongelada = new RefeicaoCongelada();
        refeicaoCongelada.descongelar();
        refeicaoCongelada.iniciarCozedura();
        refeicaoCongelada.terminarCozedura();
        refeicaoCongelada.terminarCozedura();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia4() {
        RefeicaoCongelada refeicaoCongelada = new RefeicaoCongelada();
        refeicaoCongelada.descongelar();
        refeicaoCongelada.iniciarCozedura();
        refeicaoCongelada.terminarCozedura();
        refeicaoCongelada.iniciarCozedura();
    }
}
