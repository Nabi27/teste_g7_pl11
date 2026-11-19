package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Emprestar um livro da biblioteca. */
@StateSet({"disponivel", "requisitado", "atrasado", "perdido"})
public class EmprestimoLivro {

    @StateRefinement(to="disponivel()")
    public EmprestimoLivro() {}

    /** Dá o livro como perdido (definitivo). */
    @StateRefinement(from="true", to="true")
    public void declararPerdido() {}

    /** Renova o empréstimo (o livro continua requisitado). */
    @StateRefinement(from="true", to="true")
    public void renovar() {}

    /** Devolve o livro à biblioteca. */
    @StateRefinement(from="true", to="true")
    public void devolver() {}

    /** Requisita o livro. */
    @StateRefinement(from="disponivel()", to="requisitado()")
    public void requisitar() {}

    /** Marca o empréstimo como atrasado. */
    @StateRefinement(from="true", to="true")
    public void marcarAtraso() {}
}
