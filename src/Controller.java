
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller {
    private Model model;
    private View view;

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

            model.createEntry(body, user);
            view.appdatelist(model.getEntries());
        }
    }

    private class SparafilListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                File.save(model, "model.obj");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class OpenListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                model=File.load("model.obj");
                view.appdatelist(model.getEntries());
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}