package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Abrir e fechar uma porta com fechadura. */
@StateSet({"trancada", "fechada", "aberta", "partida"})
public class Porta {

    @StateRefinement(to="trancada()")
    public Porta() {}

    /** Tranca a porta. */
    @StateRefinement(from="true", to="true")
    public void trancar() {}

    /** Fecha a porta. */
    @StateRefinement(from="true", to="true")
    public void fechar() {}

    /** Arromba a porta (definitivo). */
    @StateRefinement(from="true", to="true")
    public void arrombar() {}

    /** Destranca a porta; fica fechada. */
    @StateRefinement(from="trancada()", to="fechada()")
    public void destrancar() {}

    /** Abre a porta. */
    @StateRefinement(from="true", to="true")
    public void abrir() {}
}
