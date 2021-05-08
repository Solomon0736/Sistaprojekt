import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

public class Skapa {
    private JPasswordField lösenord;
    private JTextField anvädernamn2;
    private JLabel code2;
    private JLabel name2;
    private JPanel create;
    private JButton klarButton;

    public Skapa() {
        JFrame frame = new JFrame("");
        frame.setContentPane(this.create);
        frame.setTitle(" loggboken projekt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);
        klarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JPasswordField pf = new JPasswordField();
                JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                String password = new String(pf.getPassword());

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
                                rset.getInt("id") + ", "
                                       /* rset.getString("username") + ", "+
                                        rset.getString("Password") + ", "*/

                        );
                    }

                    // insert
                    Scanner in = new Scanner(System.in);
                    System.out.println("id:");
                    //String id = in.nextLine();
                    String id = anvädernamn2.getText();
                    System.out.println(" skriv usernamne:");
                    String username = in.nextLine();
                    System.out.println("skriv Password:");
                    String Password = in.nextLine();

                    SQLQuery = "INSERT INTO user(id,username,Password) " +
                            "VALUES ('" + id + "', '" + username + "' , + '"+Password+"')";
                    stmt.executeUpdate(SQLQuery);

                    SQLQuery = "UPDATE INTO user(id,username,Password) " +
                            "VALUES ('" + id + "', '" + username + "' , + '"+Password+"')";
                    stmt.executeUpdate(SQLQuery);

                    stmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
    public static void main(String[] args) {
        Skapa skapa = new Skapa();

    }
}
