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

     public Controller(seli seli, Skapa skapa) {
         this.model = model;
         this.view = view;
         this.seli=seli;
         this.skapa=skapa;

        this.view.addsparaButtonListener(new sparaButtonListener());
        // this.view.addvisaListener(new SparafilListener());
     }


     /*private class sparaButtonListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             String id = view.getIdtext();
             String namn = view.getNamnTextField();
             String datum = view.getDatumText();
            String meddelande = view.getMeddelandeTextField();

             model.createEnter(id, namn, datum,meddelande);
             view.appdatelist(model.getEntries());
         }
     }*/

     private class sparaButtonListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             try {
                 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/program? " +
                         "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "solomon", password);
                 Statement stmt = conn.createStatement();


                 String SQLquery = "INSERT INTO story(id,user,Datum,body) " +
                         "VALUES (`id`, `namn`, `meddelande`, `Datum`)";

                 String body = view.getBodyText();
                 String user = view.getUserText();
                 String datum = view.getDatumText();
                 String id = view.getIdText();

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
             } catch (IOException ex) {
                 ex.printStackTrace();
             } catch (ClassNotFoundException ex) {
                 ex.printStackTrace();
             }
             view.appdatelist(model.getEntries());


         }
     }
 }


