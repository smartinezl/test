package supermercat;

import java.time.LocalDate;

/**
 * La classe Carro descriu un carro de la compra on s'hi van afegint productes
 * fins a un maxim establert.
 *
 * @author Sergi Martinez Limon
 */
public class Carro {

    /**
     * Maxim de productes que pot haver-hi en un carro.
     */
    public static final int MAX_PRODUCTES = 100;

    private final Producte[] productes;
    private int nProductes;
    private double preuTotal;

    /**
     * Constructor.
     */
    public Carro() {
        productes = new Producte[MAX_PRODUCTES];
        nProductes = 0;
        preuTotal = 0;
    }

    /**
     * Obte el valor del camp nProductes.
     *
     * @return el ombre de productes dins el carro.
     */
    public int getNProductes() {
        return nProductes;
    }

    /**
     * Obte el valor del camp preuTotal.
     *
     * @return el preu total de la compra
     */
    public double getPreuTotal() {
        return preuTotal;
    }

    /**
     * Afegeix un producte al carro.
     *
     * @param p producte a afegir.
     */
    public void afegirProducte(Producte p) {
        productes[nProductes] = p;
        preuTotal += p.calcularPreu();
        nProductes++;
    }

    /**
     * Buida el carro de la compra, es calcula el preu final i es genera el
     * tiquet.
     */
    public void passarPerCaixa() {
        Producte[] productesNoRepetits = new Producte[MAX_PRODUCTES];
        int[] productesUnitats = new int[MAX_PRODUCTES];
        int nProductesNoRepetits = 0, cerca;
        boolean trobat;
        double preu;
        for (int i = 0; i < nProductes; i++) {
            cerca = 0;
            trobat = false;
            while (cerca < nProductesNoRepetits && !trobat) {
                if (productes[i].getCodiBarres().equals(productesNoRepetits[cerca].getCodiBarres()) && productes[i].calcularPreu() == productesNoRepetits[cerca].calcularPreu()) {
                    trobat = true;
                } else {
                    cerca++;
                }
            }
            if (trobat) {
                productesUnitats[cerca]++;
            } else {
                productesNoRepetits[nProductesNoRepetits] = productes[i];
                productesUnitats[nProductesNoRepetits] = 1;
                nProductesNoRepetits++;
            }
        }
        System.out.println();
        System.out.println("SUPERMERCAT BOSC DE LA COMA");
        System.out.printf("DATA: %02d/%02d/%04d\n", LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        System.out.println("PRODUCTE            UNITATS          PREU UNITARI            TOTAL");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < nProductesNoRepetits; i++) {
            preu = productesUnitats[i] * productesNoRepetits[i].calcularPreu();
            System.out.printf("%1$-20s%2$7d%3$20.2f €%4$15.2f €\n", productesNoRepetits[i].getNom(), productesUnitats[i], productesNoRepetits[i].calcularPreu(), preu);
        }
        System.out.printf("TOTAL A PAGAR: %.2f €\n", preuTotal);
        System.out.println();
        buidarCarro();
    }

    /**
     * Mostra el nom de cada producte dins el carro i la quantitat que n'hi ha.
     */
    public void mostrar() {
        Producte[] productesNoRepetits = new Producte[MAX_PRODUCTES];
        int[] productesUnitats = new int[MAX_PRODUCTES];
        int nProductesNoRepetits = 0, cerca;
        boolean trobat;
        for (int i = 0; i < nProductes; i++) {
            cerca = 0;
            trobat = false;
            while (cerca < nProductesNoRepetits && !trobat) {
                if (productes[i].getCodiBarres().equals(productesNoRepetits[cerca].getCodiBarres())) {
                    trobat = true;
                } else {
                    cerca++;
                }
            }
            if (trobat) {
                productesUnitats[cerca]++;
            } else {
                productesNoRepetits[nProductesNoRepetits] = productes[i];
                productesUnitats[nProductesNoRepetits] = 1;
                nProductesNoRepetits++;
            }
        }
        System.out.println();
        System.out.println("PRODUCTE            UNITATS");
        System.out.println("---------------------------");
        for (int i = 0; i < nProductesNoRepetits; i++) {
            System.out.printf("%-20s%7d\n", productesNoRepetits[i].getNom(), productesUnitats[i]);
        }
        System.out.println();
    }

    /**
     * Buida el carro de la compra.
     */
    private void buidarCarro() {
        for (int i = 0; i < productes.length; i++) {
            productes[i] = null;
        }
        nProductes = 0;
        preuTotal = 0;
    }

}
