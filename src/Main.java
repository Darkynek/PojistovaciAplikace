import java.util.List;
import java.util.Scanner;

// Třída pro spuštění programu.
class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SpravaPojisteni spravaPojisteni = new SpravaPojisteni();

    public static void main(String[] args) {
        while (true) {
            zobrazMenu(); // Zobrazí menu
            int volba = scanner.nextInt(); // Načte volbu, kterou uživatel zadá
            scanner.nextLine(); // Vyprázdnění bufferu pro další vstupy

            switch (volba) {
                case 1:
                    pridatPojistence(); // Volba pro přidání nového pojištěnce
                    break;
                case 2:
                    zobrazVsechnyPojistene(); // Volba pro zobrazení všech pojištěných
                    break;
                case 3:
                    vyhledatPodleJmena(); // Volba pro vyhledání podle jména a příjmení
                    break;
                case 4:
                    vyhledatPodleTelefonu(); // Volba pro vyhledání podle telefonního čísla
                    break;
                case 5:
                    System.out.println("Konec programu."); // Ukončení programu
                    return;
                default:
                    System.out.println("Neplatná volba. Zadejte prosím platnou volbu"); // neplatná volba při zadavání
                    break;
            }
        }
    }

    // Metoda pro zobrazení menu programu
    private static void zobrazMenu() {
        System.out.println("VYBERTE AKCI");
        System.out.println("1 - Přidat pojištěnce");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného podle jména a příjmení");
        System.out.println("4 - Vyhledat pojištěného podle telefonního čísla");
        System.out.println("5 - Konec");
    }

    // Metoda pro přidání pojištěnce
    private static void pridatPojistence() {
        System.out.println("Zadejte informace o pojištěnci");
        // Načtení a validace informací o novém pojištěnci
        String jmeno = nactiAValidujJmeno("Zadej jméno:");
        String prijmeni = nactiAValidujJmeno("Zadej příjmení:");
        int vek = nactiAValidujVek();
        String telefonniCislo = nactiAValidujTelefon();

        // Vytvoření nového pojištěného
        spravaPojisteni.vytvorPojistence(jmeno, prijmeni, vek, telefonniCislo);
        System.out.println("Nový pojistěný byl přidán");
    }

    // Metoda pro načtení a validaci jména
    private static String nactiAValidujJmeno(String prompt) {
        String text;
        do {
            System.out.println(prompt);
            text = scanner.nextLine().trim();
            if (text.isEmpty() || !text.matches("[a-zA-Z]+")) { // podmínky pokud je text prázdný nebo neobsahuje znaky a-z
                System.out.println("Zadejte prosím platné jméno nebo příjmení");
            } else {
                break;
            }
        } while (true);
        return text;
    }

    // Metoda pro načtení a validaci věku
    private static int nactiAValidujVek() {
        int vek;
        do {
            System.out.println("Zadejte prosím věk pojištence:");
            if (scanner.hasNextInt()) {
                vek = scanner.nextInt();
                scanner.nextLine(); // Vyprázdnění bufferu pro další vstupy
                if (vek > 0) {
                    break;
                }
            }
            System.out.println("Zadejte prosím platný věk");
            scanner.nextLine(); // Odstranění neplatného vstupu. Důvod - smyčka v programu
        } while (true);
        return vek;
    }

    // Metoda pro načtení a validaci telefonního čísla
    private static String nactiAValidujTelefon() {
        String telefon;
        do {
            System.out.println("Zadejte prosím telefonní číslo pojištence:");
            telefon = scanner.nextLine().trim(); // Načtení a odstranění mezer
            if (!telefon.matches("\\d+")) { // pokud neobsahuje jen číslice nebo číslice (negace)
                System.out.println("Zadejte prosím platné telefonní číslo");
            } else {
                break;
            }
        } while (true);
        return telefon;
    }

    // Metoda pro zobrazení všech pojištěných
    private static void zobrazVsechnyPojistene() {
        System.out.println("Seznam pojištěných:");
        spravaPojisteni.zobrazSeznamPojistenych();
    }

    // Metoda pro vyhledání pojištěného podle jména a příjmení
    private static void vyhledatPodleJmena() {
        System.out.println("Zadejte jméno a příjmení pojištěného s mezerou:");
        String[] jmenoPrijmeni = scanner.nextLine().split(" ");  // Načtení vstupu a rozdělení na jméno a příjmení podle mezery
        String hledaneJmeno = jmenoPrijmeni[0]; // Získání jména
        String hledanePrijmeni = jmenoPrijmeni[1]; // Získání příjmení

        Pojisteny hledany = spravaPojisteni.najdiPojisteneho(hledaneJmeno, hledanePrijmeni);
        if (hledany != null) {
            System.out.println("Nalezený pojištěný : " + hledany);
        } else {
            System.out.println("Pojištěný nebyl nalezen");
        }
    }

    // Metoda pro vyhledání pojištěného podle telefonního čísla
    private static void vyhledatPodleTelefonu() {
        System.out.println("Zadejte prosím telefonní číslo pojištěného:");
        String hledaneTelefonniCislo = scanner.nextLine();

        List<Pojisteny> nalezeniPodleTelCisla = spravaPojisteni.najdiPojistenehoPodleTelCisla(hledaneTelefonniCislo);  // Vyhledání pojištěného podle telefonního čísla
        if (!nalezeniPodleTelCisla.isEmpty()) {  // nesmí být prázdný (negace)
            System.out.println("Nalezený pojištěný podle telefonního čísla:");
            for (Pojisteny nalezeny : nalezeniPodleTelCisla) { // procházení nalezených pojištěných
                System.out.println(nalezeny.toString());
            }
        } else {
            System.out.println("Pojištěný nebyl nalezen podle telefonního čísla");
        }
    }
}
