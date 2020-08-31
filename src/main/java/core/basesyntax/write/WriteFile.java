package core.basesyntax.write;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile implements FileWriterServ {
    private static final String HEAD_OF_FILE = "fruit, quantity\n";

    public void writingToFile(String path, String totalFruit) {
        try (FileWriter writer = new FileWriter(path, false)) {
            String text = HEAD_OF_FILE + totalFruit;
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException("No such file", e);
        }
    }
}
