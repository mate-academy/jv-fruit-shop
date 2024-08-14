package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(filePath))) {
            bufferedWriter.write(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can not write to file: " + filePath, e);
        }
    }
}
