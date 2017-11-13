package supermercat;

/**
 * La classe Electronica descriu les caracteristiques especifiques d'un producte
 * de la seccio d'electronica, obtenint com a base les caracteristiques generals
 * del producte.
 *
 * @author Sergi Martinez Limon
 */
public class Electronica extends Producte {

    private long diesGarantia;

    /**
     * Constructor.
     *
     * @param nom nom del producte.
     * @param preu preu del producte.
     * @param codiBarres codi de barres del producte.
     * @param diesGarantia dies de garantia del producte.
     */
    public Electronica(String nom, double preu, String codiBarres, long diesGarantia) {
        super(nom, preu, codiBarres);
        this.diesGarantia = diesGarantia;
    }

    /**
     * Obte el valor del camp diesGarantia.
     *
     * @return els dies de garantia.
     */
    public long getDiesGarantia() {
        return diesGarantia;
    }

    /**
     * Estableix el valor el camp diesGarantia.
     *
     * @param diesGarantia els dies de garantia.
     */
    public void setDiesGarantia(long diesGarantia) {
        this.diesGarantia = diesGarantia;
    }

    /**
     * Calcula el preu del producte.
     *
     * @return el preu final del producte.
     */
    @Override
    public double calcularPreu() {
        return preu + preu * (diesGarantia / 365f) * 0.1;
    }

}
