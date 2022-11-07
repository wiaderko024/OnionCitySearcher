import javax.swing.*;
import java.awt.*;
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
        JFrame frame = new JFrame("Wybierz kraj:");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 200));
        frame.setResizable(true);
        frame.setLayout(new GridLayout(3, 1));

        JButton button1 = new JButton("Polska");
        JButton button2 = new JButton("Norwegia");
        JButton button3 = new JButton("Szwecja");

        button1.addActionListener(e -> {
            try {
                CityLoader loader = new CityLoader("poland.csv");
                PolandCityModel model = new PolandCityModel(loader.getCities());
                frame.setVisible(false);
                new PolandJFrame(model, loader);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        button2.addActionListener(e -> {
            try {
                CityLoader loader = new CityLoader("norway.csv");
                NorwayCityModel model = new NorwayCityModel(loader.getCities());
                frame.setVisible(false);
                new NorwayJFrame(model, loader);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        button3.addActionListener(e -> {
            try {
                CityLoader loader = new CityLoader("sweden.csv");
                SwedenCityModel model = new SwedenCityModel(loader.getCities());
                frame.setVisible(false);
                new SwedenJFrame(model, loader);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        frame.setVisible(true);
    }

}
