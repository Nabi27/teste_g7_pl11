package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Preparar o solo para plantar sementes. */
@StateSet({"duro", "solto", "adubado", "semeado", "colhido"})
public class Canteiro {

    @StateRefinement(to="duro()")
    public Canteiro() {}

    /** Aduba a terra solta. */
    @StateRefinement(from="true", to="true")
    public void adubar() {}

    /** Colhe o que foi semeado. */
    @StateRefinement(from="true", to="true")
    public void colher() {}

    /** Lavra a terra, deixando-a solta. */
    @StateRefinement(from="duro()", to="solto()")
    public void lavrar() {}

    /** Deixa o canteiro repousar; a terra volta a ficar dura. */
    @StateRefinement(from="true", to="true")
    public void repousar() {}

    /** Semeia (com ou sem adubo). */
    @StateRefinement(from="true", to="true")
    public void semear() {}
}
