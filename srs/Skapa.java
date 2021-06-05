import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;

public class Skapa {
    private JPanel create;
    private JTextField anvädernamn2;
    private JPasswordField lösenord;
    private JLabel name2;
    private JLabel code2;
    private JButton klarButton;
    private JButton tillbakaButton;
    String password = "password";
    public Skapa() {
        JFrame frame = new JFrame("");
        // frame.setContentPane(this.create);
        frame.setTitle(" loggboken ");
        frame.setContentPane(this.create);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);

        klarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    // Set up connection to database
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/program? " +
                                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                            "solomon", password);

                    // Setup statement
                    Statement stmt = conn.createStatement();
                    // Create query and execute
                    String SQLQuery = "select * from user";
                    ResultSet rset = stmt.executeQuery(SQLQuery);

                    // Loop through the result set and print
                    // Need to know the table-structure
                    while (rset.next()) {
                        System.out.println(
                                //rset.getInt("id") + ", "
                                  /*      rset.getString("username") + ", "+
                                        rset.getString("Password") + ", "*/

                        );
                    }

                    // insert
                   /* System.out.println("id:");
                    String id = i.getText();*/
                    //String id = anvädernamn2.getText();
                    String username = anvädernamn2.getText();
                    String Password =lösenord.getText();

                    SQLQuery = "INSERT INTO user(username,Password) " +
                            "VALUES ( '" + username + "' , + '"+Password+"')";
                    stmt.executeUpdate(SQLQuery);

                    SQLQuery = "UPDATE INTO user(username,Password) " +
                            "VALUES ( '" + username + "' , + '"+Password+"')";
                    stmt.executeUpdate(SQLQuery);

                    stmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
       /* tillbakaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                seli seli = new seli();
            }
        });*/
    }
    //public static void main(String[] args) {
     //   Skapa skapa = new Skapa();

   // }
}