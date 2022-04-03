import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class Calculator extends Component {
    private JButton dzielenie;
    private JPanel glownyPanel;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;
    private JButton mnozenie;
    private JButton odejmowanie;
    private JButton dodawanie;


    public Calculator() {

        dzielenie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double a = Double.parseDouble(formattedTextField1.getText());
                    Double b = Double.parseDouble(formattedTextField2.getText());
                    if (a.equals(0.0)) {
                        formattedTextField3.setText("Error");
                        JOptionPane.showMessageDialog(Calculator.this, "Nie dziel przez zero", "Critical error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        Double wynik = b / a;
                        formattedTextField3.setText(wynik.toString());
                    }
                } catch (Error error) {
                    System.out.println("error = " + error);
                }
            }
        });

        dodawanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double a = Double.parseDouble(formattedTextField1.getText());
                Double b = Double.parseDouble(formattedTextField2.getText());
                Double wynik = b+a;
                formattedTextField3.setText(wynik.toString());
            }
        });
        odejmowanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double a = Double.parseDouble(formattedTextField1.getText());
                Double b = Double.parseDouble(formattedTextField2.getText());
                Double wynik = b-a;
                formattedTextField3.setText(wynik.toString());
            }
        });
        mnozenie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double a = Double.parseDouble(formattedTextField1.getText());
                Double b = Double.parseDouble(formattedTextField2.getText());
                Double wynik = b*a;
                formattedTextField3.setText(wynik.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame ramka = new JFrame("Kalkulator");
        ramka.setContentPane(new Calculator().glownyPanel);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.pack();
        ramka.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(false);
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);

        formattedTextField1 = new JFormattedTextField(numberFormatter);
        formattedTextField2 = new JFormattedTextField(numberFormatter);
    }
    

}
