import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Heuristika {
    private FileReader fileReader;
    private FileWriter fileWriter;

    private int hmotnostPredmetovVBatohu;
    private int pocetPrvkovVBatohu;
    private int HUF;

    private List<Predmet> predmetyVBatohu;
    private List<Integer> uzSpracovanePredmety;

    public Heuristika(String suborHmotnosti, String suborCeny) {
        this.fileReader = new FileReader();
        try{
            this.predmetyVBatohu = this.fileReader.nacitajPrvky(suborHmotnosti, suborCeny);
        } catch (IOException e) {
            System.out.println("Nastala chyba pri citani suboru: " + e.getMessage());
        }

        for (Predmet p: this.predmetyVBatohu) {
            this.hmotnostPredmetovVBatohu += p.getHmotnostPredmetu();
            this.HUF += p.getCenaPredmetu();
        }
        this.pocetPrvkovVBatohu = this.predmetyVBatohu.size();
        this.uzSpracovanePredmety = new ArrayList<Integer>();
    }

    public void spustiHeuristiku() {
        Predmet predmetSNajvacsouCenou = this.predmetyVBatohu.getFirst();
        while (true) {
            for (Predmet p : predmetyVBatohu) {
                if (p.getCenaPredmetu() > predmetSNajvacsouCenou.getCenaPredmetu()) {
                    predmetSNajvacsouCenou = p;
                }
            }

            if (this.pocetPrvkovVBatohu - 1 >= 320 && this.hmotnostPredmetovVBatohu - predmetSNajvacsouCenou.getHmotnostPredmetu() >= 9450) {
                // Odstrániť predmet zo zoznamu
                this.pocetPrvkovVBatohu--;
                this.hmotnostPredmetovVBatohu -= predmetSNajvacsouCenou.getHmotnostPredmetu();
                this.HUF -= predmetSNajvacsouCenou.getCenaPredmetu();
                predmetyVBatohu.remove(predmetSNajvacsouCenou);
            } else {
                // Ak podmienky nie sú splnené, ukonči algoritmus
                break;
            }
        }
    }

    public void dajVystup() throws IOException {
        this.fileWriter = new FileWriter("vystup.txt");
        System.out.println("Pocet predmetov = " + this.pocetPrvkovVBatohu);
        System.out.println("Hmotnost = " + this.hmotnostPredmetovVBatohu);
        System.out.println("HUF = " + this.HUF);

        try (BufferedWriter writer = new BufferedWriter(this.fileWriter)) {
            writer.write("Pocet predmetov = " + this.pocetPrvkovVBatohu);
            writer.newLine();
            writer.write("Hmotnost = " + this.hmotnostPredmetovVBatohu);
            writer.newLine();
            writer.write("HUF = " + this.HUF);
            writer.newLine();
            writer.newLine(); // prázdny riadok

            for (Predmet p : this.predmetyVBatohu) {
                writer.write(String.valueOf(p.getCenaPredmetu()));
                writer.write(" ");
            }
        }
    }
}
