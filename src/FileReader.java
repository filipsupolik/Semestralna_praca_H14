import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<Predmet> nacitajPrvky(String cestaHmotnosti, String cestaCeny) throws IOException {
        List<String> riadkyHmotnosti = Files.readAllLines(Paths.get(cestaHmotnosti));
        List<String> riadkyCien = Files.readAllLines(Paths.get(cestaCeny));

        if (riadkyHmotnosti.size() != riadkyCien.size()) {
            throw new IllegalArgumentException("Počet riadkov v súboroch sa nezhoduje!");
        }

        List<Predmet> prvky = new ArrayList<>();
        for (int i = 0; i < riadkyHmotnosti.size(); i++) {
            int hmotnost = Integer.parseInt(riadkyHmotnosti.get(i).trim());
            int cena = Integer.parseInt(riadkyCien.get(i).trim());
            prvky.add(new Predmet(hmotnost, cena));
        }

        return prvky;
    }
}
