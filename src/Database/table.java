package Database;
import sun.plugin2.message.Message;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class table extends medelandet {
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
    String password= "password";

    public table() {

        // skapat färge på kantena av logga
        Border backogg_jpanel_border = BorderFactory.createMatteBorder(0, 2, 2, 3, Color.black);
         backlogg_jpanel.setBorder(backogg_jpanel_border);

        loga.addActionListener(new ActionListener() {
            private String name;

            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    //out.println(view.getText() + " " + view.getUsername());
                    //out.flush();
                    //System.out.println(view.getText() + " " + view.getUsername());

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/te18? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "solomon", password);
                    Statement stmt = conn.createStatement();

                    String SQLQuery ="select name,password from link ";
                    ResultSet rset = stmt.executeQuery(SQLQuery);

                    // Loop through the result set and print
                    // Need to know the table-structure
                    while (rset.next()) {
                        System.out.println(
                                        rset.getString("name") + " : " +
                                         rset.getString("password") + " : " );

                    }
                    if (name == "solomon") {
                        System.out.println(användernamn.getText() + " " + password1.getText());
                        medelandet M =new medelandet();

                    }


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                }
            });
        
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("table");
        frame.setContentPane(new table().huvud);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        }
}
