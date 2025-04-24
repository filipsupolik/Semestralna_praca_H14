import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Heuristika heuristika = new Heuristika("DataFiles/H4_a.txt", "DataFiles/H4_c.txt");
        heuristika.spustiHeuristiku();
        try {
            heuristika.dajVystup();
        } catch (IOException e) {
            System.out.println("Nastala chyba pri zapise do suboru: " + e.getMessage());
        }
    }
}