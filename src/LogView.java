import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogView  {
    private JPanel tabl;
    private JPanel huvud;
    private JLabel loggain;
    private JPanel backlogg_jpanel;
    private JTextField användernamn;
    private JPasswordField password1;
    private JButton clearButton;
    private JLabel username;
    private JLabel lösenord;
    private JButton loga;
    String password = "password";
    private String name;
    private boolean visible;

    public LogView() {
        JFrame frame = new JFrame("table");
        frame.setContentPane(this.huvud);
        frame.setTitle(" loggboken projekt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);
        // skapat färge på kantena av logga
        Border backogg_jpanel_border = BorderFactory.createMatteBorder(0, 2, 2, 3, Color.black);
        backlogg_jpanel.setBorder(backogg_jpanel_border);
        loga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
/**
 * Här connectar jag databasen med intelija
 * Jag har gjort name och password i link databassen
 */
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/te18? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "solomon", password);
                    Statement stmt = conn.createStatement();
                    String SQLQuery = "select name,password from link ";
                    ResultSet rset = stmt.executeQuery(SQLQuery);

                    String username = användernamn.getText();
                    String lösenord = password1.getText();
/**
 *  Jag har select name och password från link databssen ska bli samma som användernamn och password1
 *  så att den ska man kan logga in annars man får inte komma in.
 *  Om man k
 *
 */
                   while (rset.next()) {
                        if (username.equals(rset.getString("name" ))&& lösenord.equals(rset.getString("password"))){

                            frame.dispose();
                            View M = new View();
                            break;
                        }

                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
                // den tabbort allt som finns i anänder och password
                clearButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if (actionEvent.getSource() == clearButton) {
                            användernamn.setText("");
                            password1.setText("");
                        }
                    }
                });
            }
        }