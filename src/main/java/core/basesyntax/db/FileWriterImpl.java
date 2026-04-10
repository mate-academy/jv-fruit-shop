package core.basesyntax.db;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String data, String filePath) {
        try (BufferedWriter bw =
                     new BufferedWriter(new java.io.FileWriter(filePath))) {
            bw.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
