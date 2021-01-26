
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    private Model model;
    private View view;
    String password = "password";
    private JTextField bodyText;
    private JTextField userText;
    private JTextField datumText;


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

            model.createEntry(body, user, datum);
            view.appdatelist(model.getEntries());
        }
    }

    private class SparafilListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/te18? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "solomon", password);
                    Statement stmt = conn.createStatement();
                    String SQLquery = "INSERT INTO `story` (`id`, `body`, `user`, `Datum`) VALUES ('2', 'gör insert i databas', 'Magnus', '12-01-2021')";

                    String bodyText = view.getBodyText();
                    String user = view.getUserText();
                    String Datum = view.getdatumText();


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
