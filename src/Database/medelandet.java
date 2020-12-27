package Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class medelandet {
    private JTextField userText;
    private JTextField bodyText;
    private JTextField datumText;
    private JPanel baksida;
    private JTextArea Messages;
    private JButton spara;
    String password = "password";



    public medelandet() {
        JFrame frame = new JFrame("table");
        frame.setContentPane(baksida);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/te18? " +
                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "solomon", password);

            Statement stmt = conn.createStatement();
            String SQLQuery = "select * from story";
            ResultSet rset = stmt.executeQuery(SQLQuery);

            while (rset.next()) {
                Messages.append(
                        rset.getInt("id") + ", " +
                                rset.getString("user") + " :  " +
                                rset.getString("datum") + " :  " +
                                rset.getString("body") + " \n ");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        spara.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {


            }
        });

    }

}