package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Verter o conteúdo de uma garrafa. */
@StateSet({"selada", "aberta", "aVerter", "vazia", "tapada"})
public class Garrafa {

    @StateRefinement(to="selada()")
    public Garrafa() {}

    /** Inclina a garrafa e começa a verter. */
    @StateRefinement(from="true", to="true")
    public void inclinar() {}

    /** Volta a pôr a tampa (definitivo). */
    @StateRefinement(from="true", to="true")
    public void tapar() {}

    /** Endireita a garrafa e pára de verter. */
    @StateRefinement(from="true", to="true")
    public void endireitar() {}

    /** Tira a tampa da garrafa. */
    @StateRefinement(from="selada()", to="aberta()")
    public void abrir() {}

    /** O último conteúdo sai da garrafa. */
    @StateRefinement(from="true", to="true")
    public void esvaziar() {}
}
