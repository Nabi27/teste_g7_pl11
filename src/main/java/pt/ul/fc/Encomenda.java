package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Entregar uma encomenda. */
@StateSet({"criada", "expedida", "entregue", "devolvida", "arquivada"})
public class Encomenda {

    @StateRefinement(to="criada()")
    public Encomenda() {}

    /** Volta a preparar a encomenda devolvida. */
    @StateRefinement(from="true", to="true")
    public void repor() {}

    /** O destinatário recusa a encomenda; é devolvida. */
    @StateRefinement(from="true", to="true")
    public void recusar() {}

    /** Arquiva a encomenda (definitivo). */
    @StateRefinement(from="true", to="true")
    public void arquivar() {}

    /** Entrega a encomenda ao destinatário. */
    @StateRefinement(from="true", to="true")
    public void entregar() {}

    /** Expede a encomenda. */
    @StateRefinement(from="criada()", to="expedida()")
    public void expedir() {}
}
