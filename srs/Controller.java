import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

 public class Controller {
     private Skapa skapa;
     private seli seli;
     private Model model;
     private JTextField idtext;
     private JTextField meddelandeTextField;
     private JTextField namnTextField;
     private JTextField datumText;
     String password = "password";
     private View view;

     public Controller(View view,seli seli,Model model) {
         this.model = model;
         this.view = view;
         this.seli = seli;

         this.view.addsparaButtonListener(new sparaButtonListener());
         this.view.addvisaListener(new visaListener());

     }

     private class visaListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             String id = view.getIdtext();
             String namn = view.getNamnTextField();
            String meddelande = view.getMeddelandeTextField();

             model.createEnter(id, namn, meddelande);
             view.appdatelist(model.getEntries());
         }
     }

     private class sparaButtonListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             try {
                 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/program? " +
                         "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "solomon", password);
                 Statement stmt = conn.createStatement();

                 String id = view.getIdtext();
                 String namn = view.getNamnTextField();
                 String meddelande = view.getMeddelandeTextField();

                 String SQLquery = "INSERT INTO story(namn,meddelande) " +
                         "VALUES ('"+namn+"','"+ meddelande+"')";
                 System.out.println(SQLquery);
                 stmt.executeUpdate(SQLquery);
                 File.save(model, "model.obj");

             } catch (SQLException | IOException ex) {
                 ex.printStackTrace();
             }
         }

     }

     private class OpenListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             try {
                 model = File.load("model.obj");
             } catch (IOException | ClassNotFoundException ignored) {

             }


         }
     }
 }


