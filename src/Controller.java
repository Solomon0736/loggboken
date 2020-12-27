import Database.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.addSparaListener(new SparaListener());
    }
    private class SparaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        String body = view.getBodyText();
        String user= view.getUserText();

        model.createEntry(body,user);
        }
    }
}
