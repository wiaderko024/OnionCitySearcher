import javax.swing.*;
import java.io.IOException;

public class GUI {

    public GUI() {}

    public void startGUI() {
        SwingUtilities.invokeLater(() -> {
            try {
                createGUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void createGUI() throws IOException {
        CityLoader loader = new CityLoader("data/cities.csv");
        CityModel model = new CityModel(loader.getCities());

        new MyJFrame(model, loader);
    }

}
