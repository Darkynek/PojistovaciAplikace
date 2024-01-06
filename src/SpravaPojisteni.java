import java.util.ArrayList;
import java.util.List;

// Třída pro správu pojištěných
class SpravaPojisteni {
    // Seznam pro uchování informací o pojištěných
    private final List<Pojisteny> seznamPojistenych = new ArrayList<>();

    // Metoda pro vytvoření nového pojištěného a přidání do seznamu
    public void vytvorPojistence(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        Pojisteny pojisteny = new Pojisteny(jmeno, prijmeni, vek, telefonniCislo);
        seznamPojistenych.add(pojisteny);
    }

    // Metoda pro zobrazení seznamu všech pojištěných
    public void zobrazSeznamPojistenych() {
        for (Pojisteny pojisteny : seznamPojistenych) {
            System.out.println(pojisteny.toString());
        }
    }

    // Metoda pro vyhledání pojištěného podle jména a příjmení
    public Pojisteny najdiPojisteneho(String jmeno, String prijmeni) {
        for (Pojisteny pojisteny : seznamPojistenych) {
            if (pojisteny.getJmeno().equalsIgnoreCase(jmeno) && pojisteny.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                return pojisteny;
            }
        }
        return null; // Pokud není pojištěný nalezen, vrátí se null
    }

    // Metoda pro vyhledání pojištěného podle telefonního čísla
    public List<Pojisteny> najdiPojistenehoPodleTelCisla(String telefonniCislo) {
        List<Pojisteny> nalezeni = new ArrayList<>();
        for (Pojisteny pojisteny : seznamPojistenych) {
            if (pojisteny.getTelefonniCislo().equals(telefonniCislo)) {
                nalezeni.add(pojisteny);
            }
        }
        return nalezeni; // Vrací seznam nalezených pojištěných podle telefonního čísla
    }
}