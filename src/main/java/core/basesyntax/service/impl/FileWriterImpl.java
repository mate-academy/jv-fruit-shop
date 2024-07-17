package core.basesyntax.service.impl;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl {
    public void write(String data, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
        } catch (IOException e) {
            throw new IOException("Error writing to file: " + filePath, e);
        }
    }
}
