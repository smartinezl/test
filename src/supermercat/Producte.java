package supermercat;

/**
 * La classe abstracta Producte descriu les caracteristiques generals d'un
 * producte.
 *
 * @author Sergi Martinez Limon
 */
public abstract class Producte {

    protected double preu;
    protected String nom, codiBarres;

    /**
     * Constructor.
     *
     * @param nom nom del producte.
     * @param preu preu del producte.
     * @param codiBarres codi de barres del producte.
     */
    public Producte(String nom, double preu, String codiBarres) {
        this.nom = nom;
        this.preu = preu;
        this.codiBarres = codiBarres;
    }

    /**
     * Obte el valor del camp preu.
     *
     * @return el preu.
     */
    public double getPreu() {
        return preu;
    }

    /**
     * Obte el valor del camp nom.
     *
     * @return el nom.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obte el valor del camp codiBarres.
     *
     * @return el codi de barres.
     */
    public String getCodiBarres() {
        return codiBarres;
    }

    /**
     * Estableix el valor del camp preu.
     *
     * @param preu el preu a establir.
     */
    public void setPreu(double preu) {
        this.preu = preu;
    }

    /**
     * Estableix el valor del camp nom.
     *
     * @param nom el nom a establir.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Estableix el valor del camp codiBarres.
     *
     * @param codiBarres el codi de barres a establir.
     */
    public void setCodiBarres(String codiBarres) {
        this.codiBarres = codiBarres;
    }

    /**
     * Calcula el preu del producte.
     *
     * @return el preu final del producte.
     */
    public abstract double calcularPreu();

}
