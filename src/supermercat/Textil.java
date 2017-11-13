package supermercat;

/**
 * La classe Textil descriu les caracteristiques especifiques d'un producte de
 * la seccio de roba, obtenint com a base les caracteristiques generals del
 * producte.
 *
 * @author Sergi Martinez Limon
 */
public class Textil extends Producte {

    private String composicio;

    /**
     * Constructor.
     *
     * @param nom nom del producte.
     * @param preu preu del producte.
     * @param codiBarres codi de barres del producte.
     * @param composicio la composicio textil del producte.
     */
    public Textil(String nom, double preu, String codiBarres, String composicio) {
        super(nom, preu, codiBarres);
        this.composicio = composicio;
    }

    /**
     * Obte el valor del camp composicio.
     *
     * @return la composicio textil.
     */
    public String getComposicio() {
        return composicio;
    }

    /**
     * Estableix el valor del camp composicio.
     *
     * @param composicio la composicio texil.
     */
    public void setComposicio(String composicio) {
        this.composicio = composicio;
    }

    /**
     * Calcula el preu del producte.
     *
     * @return el preu final del producte.
     */
    @Override
    public double calcularPreu() {
        return preu;
    }
}
