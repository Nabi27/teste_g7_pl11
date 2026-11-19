package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Avaliar um aluno. */
@StateSet({"inscrito", "entregue", "avaliado", "publicado", "desistente"})
public class AvaliacaoAluno {

    @StateRefinement(to="inscrito()")
    public AvaliacaoAluno() {}

    /** Publica a nota (definitivo). */
    @StateRefinement(from="true", to="true")
    public void publicar() {}

    /** O aluno desiste da avaliação (definitivo). */
    @StateRefinement(from="true", to="true")
    public void desistir() {}

    /** O aluno pede revisão da nota; o trabalho volta a ser avaliado. */
    @StateRefinement(from="true", to="true")
    public void pedirRevisao() {}

    /** O aluno entrega o trabalho. */
    @StateRefinement(from="inscrito()", to="entregue()")
    public void entregar() {}

    /** O docente atribui a nota ao trabalho entregue. */
    @StateRefinement(from="true", to="true")
    public void avaliar() {}
}
