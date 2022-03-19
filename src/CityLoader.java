import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CityLoader {

    private final List<String[]> cities;

    public CityLoader(String path) throws IOException {
        this.cities = readCities(path);
    }

    private List<String[]> readCities(String path) throws IOException {
        // Development
        // List<String> content = Files.readAllLines(Path.of(new File("").getAbsolutePath() + "/src/" + path));

        // Production
        List<String> content = Files.readAllLines(Path.of(path));

        List<String[]> cities = new ArrayList<>();

        for(String line : content) {
            cities.add(line.split(";"));
        }

        return cities;
    }

    public List<String[]> getCities() {
        return cities;
    }

    public List<String[]> filterCities(String text) {
        return cities.stream().filter(s -> s[0].toLowerCase(Locale.ROOT).startsWith(text) || s[0].toLowerCase(Locale.ROOT).contains(text)).collect(Collectors.toList());
    }

}
