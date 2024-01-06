// Třída pro pojištěného
class Pojisteny {
    // Proměnné pro uložení informací o pojištěnci
    private final String jmeno;
    private final String prijmeni;
    private final int vek;
    private final String telefonniCislo;

    // Konstruktor pro inicializaci informací o pojištěném
    public Pojisteny(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

    // Metoda pro získání jména pojištěného
    public String getJmeno() {
        return jmeno;
    }

    // Metoda pro získání příjmení pojištěného
    public String getPrijmeni() {
        return prijmeni;
    }

    // Metoda pro získání telefonního čísla pojištěného
    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    // Metoda sloužící k vypsání podrobností o pojištěném
    @Override
    public String toString() {
        return jmeno + " " + prijmeni + ", vek: " + vek + ", tel. cislo: " + telefonniCislo;
    }
}