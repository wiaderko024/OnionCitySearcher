import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SearchPanel extends JPanel {

    private final JLabel label;
    private final JTextField textField;
    private final JButton button;

    public SearchPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        this.label = new JLabel("Wyniki wyszukiwania: ");

        this.textField = new JTextField(60);

        this.button = new JButton("Szukaj");

        panel.add(textField);
        panel.add(label);

        add(panel);
        add(button);
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton getButton() {
        return button;
    }

}
