package supermercat;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * La classe Alimentacio descriu les caracteristiques especifiques d'un producte
 * de la seccio d'alimentacio, obtenint com a base les caracteristiques generals
 * del producte.
 *
 * @author Sergi Martinez Limon
 */
public class Alimentacio extends Producte {

    private LocalDate dataCaducitat;

    /**
     * Constructor
     *
     * @param nom nom del producte.
     * @param preu preu del producte.
     * @param codiBarres codi de barres del producte.
     * @param dataCaducitat data de caducitat del producte.
     */
    public Alimentacio(String nom, double preu, String codiBarres, LocalDate dataCaducitat) {
        super(nom, preu, codiBarres);
        this.dataCaducitat = dataCaducitat;
    }

    /**
     * Obte el valor del camp dataCaducitat.
     *
     * @return la data de caducitat.
     */
    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    /**
     * Estableix el valor del camp dataCaducitat.
     *
     * @param dataCaducitat la data de caducitat.
     */
    public void setDataCaducitat(LocalDate dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    /**
     * Calcula el preu del producte.
     *
     * @return el preu final del producte.
     */
    @Override
    public double calcularPreu() {
        return preu - preu * (1f / (DAYS.between(LocalDate.now(), dataCaducitat) + 1)) + (preu * 0.1);
    }
}
