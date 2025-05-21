import java.io.*;
import java.util.ArrayList;

public class ArquivoUtil {

    public static <T> void salvar(String nomeArquivo, ArrayList<T> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Erro ao salvar " + nomeArquivo);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> carregar(String nomeArquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (ArrayList<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}