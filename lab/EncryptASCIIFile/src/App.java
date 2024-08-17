import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
  public static void main(String[] args) {
    System.out.println("Diretório de trabalho atual: " + System.getProperty("user.dir"));

    try {
      byte[] bytes = Files.readAllBytes(Paths.get("src/files/in.txt"));
      ByteArrayOutputStream bytes2 = new ByteArrayOutputStream();

      for (byte b : bytes) {
        bytes2.write(++b);
        Files.write(Paths.get("src/files/out.txt"), bytes2.toByteArray());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
