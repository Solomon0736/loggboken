package Database;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class table {
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
        Border backogg_jpanel_border = BorderFactory.createMatteBorder(0, 2, 2, 2, Color.black);
         backlogg_jpanel.setBorder(backogg_jpanel_border);

        loga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            String sql ="select * from table where username=? and password1=?";
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "solomon", password);
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, new String(användernamn.getText()));
                    pstmt.setString(2, new String(password1.getPassword()));
                    // Set up connection to database
                } catch (SQLException e) {

                }
                }
            });
    }

    public JLabel getLoggain() {
        return loggain;
    }

    public void setLoggain(JLabel loggain) {
        this.loggain = loggain;
    }

    public JButton getLoga() {
        return loga;
    }

    public void setLoga(JButton loga) {
        this.loga = loga;
    }

    public JPanel getTabl() {
        return tabl;
    }

    public void setTabl(JPanel tabl) {
        this.tabl = tabl;
    }

    public JPanel getHuvud() {
        return huvud;
    }

    public void setHuvud(JPanel huvud) {
        this.huvud = huvud;
    }

    public JPanel getBacklogg_jpanel() {
        return backlogg_jpanel;
    }

    public void setBacklogg_jpanel(JPanel backlogg_jpanel) {
        this.backlogg_jpanel = backlogg_jpanel;
    }

    public JTextField getAnvändernamn() {
        return användernamn;
    }

    public void setAnvändernamn(JTextField användernamn) {
        this.användernamn = användernamn;
    }

    public JPasswordField getPassword1() {
        return password1;
    }

    public void setPassword1(JPasswordField password1) {
        this.password1 = password1;
    }
    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JLabel getUsername() {
        return username;
    }

    public void setUsername(JLabel username) {
        this.username = username;
    }

    public JLabel getLösenord() {
        return lösenord;
    }

    public void setLösenord(JLabel lösenord) {
        this.lösenord = lösenord;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("table");
        frame.setContentPane(new table().huvud);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
