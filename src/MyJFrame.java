import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame extends JFrame {

    public MyJFrame(CityModel model, CityLoader loader) {
        setTitle("OnionCitySearcher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1500, 900));
        setResizable(true);
        setLayout(new BorderLayout());

        SearchPanel panel = new SearchPanel();
        add(panel, BorderLayout.NORTH);

        MyJTable table = new MyJTable(model);
        add(new JScrollPane(table));

        JTextField textField = panel.getTextField();
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    model.setCities(loader.filterCities(textField.getText()));
                    model.fireTableDataChanged();
                    panel.getLabel().setText("Wyniki wyszukiwania: " + textField.getText() + " [" + model.getRowCount() + "]");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        JButton button = panel.getButton();
        button.addActionListener(e -> {
            model.setCities(loader.filterCities(textField.getText()));
            model.fireTableDataChanged();
            panel.getLabel().setText("Wyniki wyszukiwania: " + textField.getText() + "[" + model.getRowCount() + "]");
        });

        pack();
        setVisible(true);
    }

}
