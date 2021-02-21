
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;

public class Controller {
    private Model model;
    private View view;
    String password = "password";
    private JTextField bodyText;
    private JTextField userText;
    private JTextField datumText;
    private JTextField idText;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.addSparaListener(new SparaListener());
        this.view.addSparafilListener(new SparafilListener());
        this.view.addOpenListener(new OpenListener());

    }

    private class SparaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String body = view.getBodyText();
            String user = view.getUserText();
            String datum = view.getDatumText();
            String id = view.getIdText();




            model.createEntry(body, user, datum,id);
            view.appdatelist(model.getEntries());
        }
    }

    private class SparafilListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/te18? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "solomon", password);
                    Statement stmt = conn.createStatement();
                    /*String SQLquery = "INSERT INTO `story` (`id`, `body`, `user`, `Datum`) " +
                            "Value('2', 'Gör insert i databasen', 'Magnus', '19-01-2021')";*/
                            //    String SQLQuery = "select * from story";
                    //ResultSet rset = stmt.executeQuery(SQLQuery);

                    // Loop through the result set and print
                    // Need to know the table-structure
                    /*while (rset.next()) {
                        System.out.println(
                                rset.getString("id") + ", " +
                                        rset.getString("user") + ", " +
                                        rset.getString("body") + ", "+
                                         rset.getString("Datum") + ", "


                        );
                    }
*/
                    String SQLquery = "INSERT INTO story(id,user,Datum,body) " +
                            "VALUES (`id`, `body`, `user`, `Datum`)";
                    //stmt.executeUpdate(SQLQuery);

                /*    SQLQuery = "UPDATE INTO story(id,user,Datum,body) " +
                            "VALUES ( '\"+id+\"','\"+user+\"','\"+Datum+\"', '\"+body+\"')";
                    stmt.executeUpdate(SQLQuery);*/


                    String body = view.getBodyText();
                    String user = view.getUserText();
                    String datum = view.getDatumText();
                    String id = view.getIdText();

                    stmt.executeUpdate(SQLquery);
                    File.save(model, "model.obj");

                } catch (IOException | SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }

        private class OpenListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                try {
                    model = File.load("model.obj");
                    view.appdatelist(model.getEntries());
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }


            }
        }
    }
