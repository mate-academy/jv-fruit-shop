package core.basesyntax;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl {
    public void write(String data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
