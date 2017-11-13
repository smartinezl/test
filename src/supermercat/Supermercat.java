package supermercat;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * La classe Supermercat es la classe principal de l'aplicacio. La seva funcio
 * es realitzar les accions pertinents amb el carro, com afegir productes,
 * mostrar el contingut del carro o passar per caixa.
 *
 * @author Sergi Martinez Limon
 */
public class Supermercat {

    static Scanner entrada = new Scanner(System.in);

    /**
     * Metode principal. Realitxa les accions necessaries de l'aplicacio.
     *
     * @param args arguments de la linia de comandes.
     */
    public static void main(String[] args) {
        Carro carroCompra = new Carro();
        int opcio = 0;
        boolean sortir = false;
        do {
            System.out.print(menu());
            switch (opcio = entrada.nextInt()) {
                case 1:
                    opcio1(carroCompra);
                    break;
                case 2:
                    opcio2(carroCompra);
                    break;
                case 3:
                    opcio3(carroCompra);
                    break;
            }
        } while (opcio != 0);
    }

    /**
     * Conte el menu principal.
     *
     * @return el menu principal.
     */
    private static String menu() {
        return String.format("S U P E R M E R C A T   B O S C   D E   L A   C O M A\n 1. Introduir producte\n 2. Passar per caixa\n 3. Mostrar carro\n 0. Sortir\nTria una opcio: ");
    }

    /**
     * Conte el menu de productes.
     *
     * @return el menu de productes.
     */
    private static String menuProductes() {
        return String.format(" 1. Alimentacio\n 2. Textil\n 3. Electronica\n 4. Tornar\nTria una opcio: ");
    }

    /**
     * Realitza les accions de la opcio 1, que son demanar quin tipus de
     * producte es vol introduir i a continuacio les seves dades. Finalment
     * introdueix el producte.
     *
     * @param carroCompra el carro de la compra.
     */
    private static void opcio1(Carro carroCompra) {
        int opcio;
        String nom, codiBarres, dataCaducitat, composicio;
        double preu;
        int diesGarantia, dia, mes, any;
        if (!carroPle(carroCompra)) {
            System.out.print(menuProductes());
            opcio = entrada.nextInt();
            entrada.nextLine();
            switch (opcio) {
                case 1:
                    System.out.printf("Nom: ");
                    nom = entrada.nextLine();
                    System.out.printf("Preu: ");
                    preu = entrada.nextDouble();
                    entrada.nextLine();
                    System.out.printf("Codi de barres: ");
                    codiBarres = entrada.nextLine();
                    System.out.print("Data de caducitat (DD/MM/AAAA): ");
                    dataCaducitat = entrada.nextLine();
                    dia = Integer.valueOf(dataCaducitat.substring(0, 2));
                    mes = Integer.valueOf(dataCaducitat.substring(3, 5));
                    any = Integer.valueOf(dataCaducitat.substring(6));
                    carroCompra.afegirProducte(new Alimentacio(nom, preu, codiBarres, LocalDate.of(any, mes, dia)));
                    break;
                case 2:
                    System.out.printf("Nom: ");
                    nom = entrada.nextLine();
                    System.out.printf("Preu: ");
                    preu = entrada.nextDouble();
                    entrada.nextLine();
                    System.out.printf("Codi de barres: ");
                    codiBarres = entrada.nextLine();
                    System.out.printf("Composicio textil: ");
                    composicio = entrada.nextLine();
                    carroCompra.afegirProducte(new Textil(nom, preu, codiBarres, composicio));
                    break;
                case 3:
                    System.out.printf("Nom: ");
                    nom = entrada.nextLine();
                    System.out.printf("Preu: ");
                    preu = entrada.nextDouble();
                    entrada.nextLine();
                    System.out.printf("Codi de barres: ");
                    codiBarres = entrada.nextLine();
                    System.out.printf("Dies de garantia: ");
                    diesGarantia = entrada.nextInt();
                    entrada.nextLine();
                    carroCompra.afegirProducte(new Electronica(nom, preu, codiBarres, diesGarantia));
                    break;
            }
        } else {
            System.err.println("ERROR: El carro esta ple!");
        }
    }

    /**
     * Realitza l'accio de la opcio 2, que es passar per caixa i generar el
     * tiquet.
     *
     * @param carroCompra el carro de la compra.
     */
    private static void opcio2(Carro carroCompra) {
        carroCompra.passarPerCaixa();
    }

    /**
     * Realitza l'accio de la opcio 3, que es mostrar el contingut del caro de
     * la compra.
     *
     * @param carroCompra el carro de la compra.
     */
    private static void opcio3(Carro carroCompra) {
        carroCompra.mostrar();
    }

    /**
     * Comprova si el carro esta ple.
     *
     * @param carroCompra el carro de la compra.
     * @return cert si el carro es troba ple, fals si no es troba ple.
     */
    private static boolean carroPle(Carro carroCompra) {
        return carroCompra.getNProductes() == Carro.MAX_PRODUCTES;
    }
}
