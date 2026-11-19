package pt.ul.fc;

/**
 * Cliente de {@link EmprestimoLivro}. NÃO ALTERE ESTE FICHEIRO (nem sequer espaços ou comentários):
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
        EmprestimoLivro emprestimoLivro = new EmprestimoLivro();
        emprestimoLivro.renovar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia2() {
        EmprestimoLivro emprestimoLivro = new EmprestimoLivro();
        emprestimoLivro.requisitar();
        emprestimoLivro.devolver();
        emprestimoLivro.devolver();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia3() {
        EmprestimoLivro emprestimoLivro = new EmprestimoLivro();
        emprestimoLivro.declararPerdido();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia4() {
        EmprestimoLivro emprestimoLivro = new EmprestimoLivro();
        emprestimoLivro.requisitar();
        emprestimoLivro.marcarAtraso();
        emprestimoLivro.declararPerdido();
        emprestimoLivro.marcarAtraso();
    }
}
