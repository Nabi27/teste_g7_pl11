package pt.ul.fc;

/**
 * Cliente de {@link PedidoIntegracao}. NÃO ALTERE ESTE FICHEIRO (nem sequer espaços ou comentários):
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
        PedidoIntegracao pedidoIntegracao = new PedidoIntegracao();
        pedidoIntegracao.pedirRevisao();
        pedidoIntegracao.aprovar();
        pedidoIntegracao.encerrar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia2() {
        PedidoIntegracao pedidoIntegracao = new PedidoIntegracao();
        pedidoIntegracao.pedirRevisao();
        pedidoIntegracao.aprovar();
        pedidoIntegracao.pedirAlteracoes();
        pedidoIntegracao.pedirAlteracoes();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia3() {
        PedidoIntegracao pedidoIntegracao = new PedidoIntegracao();
        pedidoIntegracao.pedirRevisao();
        pedidoIntegracao.pedirAlteracoes();
        pedidoIntegracao.pedirRevisao();
        pedidoIntegracao.integrar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia4() {
        PedidoIntegracao pedidoIntegracao = new PedidoIntegracao();
        pedidoIntegracao.pedirRevisao();
        pedidoIntegracao.pedirAlteracoes();
        pedidoIntegracao.aprovar();
    }
}
