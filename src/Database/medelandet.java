package Database;//import Database.table;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class medelandet {
    private JTextField Läggtext;
    private JTextField userText;
    private JTextField bodyText;
    private JTextField datumText;
    private JPanel baksida;
    private JTextArea Messages;
    String password = "password";


    public medelandet() {
        JFrame frame = new JFrame("table");
        frame.setContentPane(baksida);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        /*Läggtext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });*/
        Läggtext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    //out.println(view.getText() + " " + view.getUsername());
                    //out.flush();
                    //System.out.println(view.getText() + " " + view.getUsername());
                    medelandet next = new medelandet();
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/te18? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "solomon", password);
                    Statement stmt = conn.createStatement();

                    String SQLQuery = "select * from story";
                    ResultSet rset = stmt.executeQuery(SQLQuery);

                    // Loop through the result set and print
                    // Need to know the table-structure
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
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("table");
        frame.setContentPane(new medelandet().baksida);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}