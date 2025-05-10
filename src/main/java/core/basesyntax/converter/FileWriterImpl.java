package core.basesyntax.converter;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new java.io.FileWriter(filePath, false))) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
