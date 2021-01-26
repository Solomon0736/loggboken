import java.io.*;

/**
 *
 */
public class File {
    public static void save(Model model, String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            out.writeObject(model);
        }
    }
    public static Model load(String fileName) throws IOException, ClassNotFoundException {
        Model model;

        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            model = (Model) in.readObject();
        }

        return model;
    }

}
