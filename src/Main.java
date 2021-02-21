
public class Main {
    public static void main(String[] args) {
        LogView logView=new LogView();

        Model model = new Model();
       View view = new View();
        Controller controller= new Controller(model,view);

    }
    }

