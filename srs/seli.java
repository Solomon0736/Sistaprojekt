import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;

public class seli {
    private JButton button1;
    private JPanel kkk;
    private JTextField användernamn;
    private JPasswordField lösenord;
    private JButton clearButton;
    private JLabel pass;
    private JLabel Name;
    private JButton nyttButton;
    private JButton loga;
    private JPanel Backgrund;
     String password = "password";

    public seli() {
        JFrame frame = new JFrame("");
        frame.setContentPane(this.kkk);
        frame.setTitle(" loggboken projekt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {

                    Connection conn = getConnection("jdbc:mysql://localhost:3306/program? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "solomon", password);
                    Statement stmt = conn.createStatement();
                    String SQLQuery = "select username,Password from user ";
                    ResultSet rset = stmt.executeQuery(SQLQuery);

                    String Name = användernamn.getText();
                    String pass = lösenord.getText();


                    while (rset.next()) {
                        if (Name.equals(rset.getString("username")) && pass.equals(rset.getString("Password"))) {
                            frame.dispose();
                            View view = new View();
                            break;
                        } else {
                            System.out.println("Du har fel användare eller password");
                            //Skapa skapa = new Skapa();
                        }
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });


        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == clearButton) {
                    användernamn.setText("");
                    lösenord.setText("");
                }
            }
        });
        nyttButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Skapa skapa =new Skapa();
            }
        });
    }

    public static void main(String[] args) {
        seli log = new seli();

    }
}