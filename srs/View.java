import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View {
    private JTextField namnTextField;
    private JTextField idtext;
    private JTextField meddelandeTextField;
    private JTextField datumText;
    private JPanel third;
    private JButton sparaButton;
    private JButton visa;
    private JTextArea skriva;

    public String getNamnTextField() {
        return namnTextField.getText();
    }

    public void setNamnTextField(JTextField namnTextField) {
        this.namnTextField = namnTextField;
    }

    public String getIdtext() {
        return idtext.getText();
    }

    public void setIdtext(JTextField idtext) {
        this.idtext = idtext;
    }

    public String getMeddelandeTextField() {
        return meddelandeTextField.getText();
    }

    public void setMeddelandeTextField(JTextField meddelandeTextField) {
        this.meddelandeTextField = meddelandeTextField;
    }

    public String getDatumText() {
        return datumText.getText();
    }

    public void setDatumText(JTextField datumText) {
        this.datumText = datumText;
    }

    public View() {
        JFrame frame = new JFrame("");
        frame.setContentPane(this.third);
        frame.setTitle(" loggboken projekt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(680, 300);
        frame.setVisible(true);
    }

    public void addsparaButtonListener(ActionListener actionListener) {
        sparaButton.addActionListener(actionListener);
    }

    public void addvisaListener(ActionListener actionListener) {
        visa.addActionListener(actionListener);
    }

   // public static void main(String[] args) {
      //  View view = new View();

   // }

    public void appdatelist(ArrayList<Enter> entries) {
        skriva.setText("");
        for (Enter enter : entries) {
            skriva.append(enter.getId() + "     " + enter.namn + "    " + enter.meddelande + "     " + enter.getDatum());
        }
    }

    public String getBodyText() {
        return null;
    }

    public String getUserText() {
        return null;
    }

    public String getIdText() {
        return null;
    }
}
