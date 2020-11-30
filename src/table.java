import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.*;

public class table {
    private JPanel tabl;
    private JPanel huvud;
    private JPanel halve;
    private JLabel logga;
    private JPanel backlogg_jpanel;

    public table() {
        // table.addActionListener(new ActionListener() {
        //     @Override
        //    public void actionPerformed(ActionEvent actionEvent) {
       // skapat färge på kantena av logga
        Border backogg_jpanel_border = BorderFactory.createMatteBorder(0,2,2,2,Color.black);
        backlogg_jpanel.setBorder(backogg_jpanel_border);
        //   }
        // });
    }

    public JLabel getLogga() {
        return logga;
    }

    public void setLogga(JLabel logga) {
        this.logga = logga;
    }

    public JPanel getBacklogg_jpanel() {
        return backlogg_jpanel;
    }

    public void setBacklogg_jpanel(JPanel backlogg_jpanel) {
        this.backlogg_jpanel = backlogg_jpanel;
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

    public JPanel getHalve() {
        return halve;
    }

    public void setHalve(JPanel halve) {
        this.halve = halve;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("loggtable");
        frame.setContentPane(new table().huvud);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
