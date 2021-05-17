import java.io.*;

public class File {
    private static Object IOException;
    private static Object ClassNotFoundException;

    public static void save(Model model, String s) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(s)))) {
            out.writeObject(model);
        }
    }

    public static Model load(String s)  throws IOException, ClassNotFoundException {
            Model model;
            try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(s)))) {
                model = (Model) in.readObject();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            } catch (java.lang.ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

