
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class View  {
    private JTextField userText;

    public String getUserText() {
        return userText.getText();
    }

    public void setUserText(JTextField userText) {
        this.userText = userText;
    }

    public String getBodyText() {
        return bodyText.getText();
    }

    public void setBodyText(JTextField bodyText) {
        this.bodyText = bodyText;
    }

    public String getDatumText() {
        return datumText.getText();
    }

    public void setDatumText(JTextField datumText) {
        this.datumText = datumText;
    }
    public String getIdText() { return idText.getText(); }

    public void setIdText(JTextField idText) { this.idText = idText; }

    private JTextField bodyText;
    //private JTextField idText;
    private JTextField datumText;
    private JPanel baksida;
    private JTextArea Messages;
    private JButton spara;
    private JButton sparafil;
    private JButton open;
    private JTextField idText;
    String password = "password";


    public View() {
       JFrame frame = new JFrame("table");
        frame.setContentPane(this.baksida);
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
                       rset.getString("id") + ", " +
                                rset.getString("user") + " :  " +
                                rset.getString("datum") + " :  " +
                                rset.getString("body") + " \n ");


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void appdatelist( ArrayList<Entry> entries){
        Messages.setText("");

       for (Entry entry : entries){
           Messages.append(entry.getBody()+ "     "+   entry.id+"    "+ entry.datum +"     "+ entry.getUser());
       }
    }
    public void addSparaListener(ActionListener actionListener) {
        spara.addActionListener(actionListener);
    }

    public void addSparafilListener(ActionListener actionListener) {
        sparafil.addActionListener(actionListener);
    }

    public void addOpenListener(ActionListener actionListener) {
        open.addActionListener(actionListener);
    }

    public String getdatumText() {
        return null;
    }
}