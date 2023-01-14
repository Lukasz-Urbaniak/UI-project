import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Kalkulator extends JFrame {
    private JLabel wattageLabel;
    private JTextField wattageField;
    private JLabel costLabel;
    private JTextField costField;
    private JLabel hoursLabel;
    private JTextField hoursField;
    private JButton calculateButton;
    private JLabel resultLabel;
    private JTextField resultField;
    private JPanel panelMain;

    public static void main(String[] args) {
        Kalkulator k = new Kalkulator();
        k.setContentPane(k.panelMain);
        k.setTitle("Kalkulator zużycia energii");
        k.setSize(550, 250);
        k.setVisible(true);
        k.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public Kalkulator() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values from text fields
                String wattageText = wattageField.getText();
                String costText = costField.getText();
                String hoursText = hoursField.getText();

                try {
                    // Convert the values into doubles for calculating the result
                    double wattage = Double.parseDouble(wattageText) / 1000;
                    double cost = Double.parseDouble(costText);
                    double hours = Double.parseDouble(hoursText);

                    // Check if the input is greater than 0
                    if (wattage <= 0 || cost <= 0 || hours <= 0 || hours > 24) {
                        JOptionPane.showMessageDialog(calculateButton, "Podane wartości muszą być większe od zera, a liczba godzin mniejsza lub równa 24.");
                    } else {
                        // Calculate the result
                        double result = wattage * cost * hours * 365;
                        // Set the result in the resultField

                        DecimalFormat df = new DecimalFormat("#.00");
                        resultField.setText(df.format(result));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(calculateButton, "Podane wartości muszą być dodatnimi liczbami z częścią dziesiętną podaną po kropce.");
                }
            }
        });
    }
}