import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempConvertor implements ActionListener {
    private static JLabel deg2Label;
    private static JTextField deg1;
    private static JTextField deg2;
    private static JLabel deg1Label;
    private static JButton convert;
    private static JButton switchButton;

    private static final String c = "Celsius:";
    private static final String f = "Fahrenheit:";
    private static boolean celsius=true;

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Temperature Convertor");
        frame.setSize(400,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel title = new JLabel("Temperature Convertor");
        title.setBounds(10, 10, 150, 30);
        panel.add(title);

        deg1Label = new JLabel(c);
        deg1Label.setBounds(80, 60, 70, 30);
        panel.add(deg1Label);

        deg1 = new JTextField();
        deg1.setBounds(160, 60,70,30);
        panel.add(deg1);

        deg2Label = new JLabel(f);
        deg2Label.setBounds(80, 100, 70, 30);
        panel.add(deg2Label);

        deg2 = new JTextField();
        deg2.setBounds(160, 100,70,30);
        panel.add(deg2);

        convert = new JButton("Convert");
        convert.setBounds(155, 140,80, 30);
        panel.add(convert);
        convert.addActionListener(new TempConvertor());

        switchButton = new JButton("Switch");
        switchButton.setBounds(250, 80,80, 30);
        panel.add(switchButton);
        switchButton.addActionListener(new TempConvertor());

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src=e.getSource();
        if (src==convert){
            convert();
        }else if (src==switchButton) {
            switchButtonClick();
        }
    }

    private void switchButtonClick() {
        celsius=!celsius;
        deg1.setText("");
        deg2.setText("");
        if (celsius){
            deg1Label.setText(c);
            deg2Label.setText(f);
        }else{
            deg1Label.setText(f);
            deg2Label.setText(c);
        }
    }

    private void convert(){
        double temp;
        try{
            temp = Double.parseDouble(deg1.getText());
        }catch(Exception ex){
            deg2.setText("NaN");
            return;
        }
        double converted;
        if (celsius){
            converted=(1.8*temp+32);
        }else{
            converted=(temp-32)/(1.8);
        }
        converted= Math.floor(converted*100)/100;

        String temperature = String.valueOf(converted);
        deg2.setText(temperature);
    }
}
