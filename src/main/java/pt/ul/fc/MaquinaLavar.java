package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Lavar roupa numa máquina de lavar. */
@StateSet({"vazia", "carregada", "aLavar", "terminada"})
public class MaquinaLavar {

    @StateRefinement(to="vazia()")
    public MaquinaLavar() {}

    /** Termina a lavagem. */
    @StateRefinement(from="true", to="true")
    public void terminar() {}

    /** Inicia a lavagem. */
    @StateRefinement(from="true", to="true")
    public void iniciar() {}

    /** Descarrega a roupa; a máquina fica vazia. */
    @StateRefinement(from="true", to="true")
    public void descarregar() {}

    /** Interrompe a lavagem; a roupa fica na máquina. */
    @StateRefinement(from="true", to="true")
    public void interromper() {}

    /** Carrega a roupa. */
    @StateRefinement(from="vazia()", to="carregada()")
    public void carregar() {}
}
