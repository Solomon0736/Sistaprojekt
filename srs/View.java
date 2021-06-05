import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class View {
    private JTextField namnTextField;
    private JTextField idtext;
    private JTextField meddelandeTextField;
    private JPanel third;
    private JButton sparaButton;
    private JButton visa;
    private JTextArea skriva;
    String password = "password";


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


    public View() {
        JFrame frame = new JFrame("");
        frame.setContentPane(this.third);
        frame.setTitle(" loggboken projekt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(680, 300);
        frame.setVisible(true);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/program? " +
                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "solomon", password);

            Statement stmt = conn.createStatement();
            String SQLQuery = "select * from story";
            ResultSet rset = stmt.executeQuery(SQLQuery);

            while (rset.next()) {
                skriva.append(
                        rset.getInt("id") + ", " +
                                rset.getString("namn") + " :  " +
                                rset.getString("meddelande") + " \n " );


            }
            SQLQuery = "INSERT INTO story(username,Password) " +
                    "VALUES ( '" + idtext + "' , + '"+namnTextField+"',  + '"+meddelandeTextField+"')";
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addsparaButtonListener(ActionListener actionListener) {
        sparaButton.addActionListener(actionListener);
    }

    public void addvisaListener(ActionListener actionListener) {
        visa.addActionListener(actionListener);
    }

    public void appdatelist(ArrayList<Enter> entries) {
        skriva.setText("");
        for (Enter enter : entries) {
            skriva.append(enter.id + "     " + enter.namn + "    " + enter.meddelande);
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
