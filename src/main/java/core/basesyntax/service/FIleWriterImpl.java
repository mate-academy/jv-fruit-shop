package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.IOException;

public class FIleWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String data, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(filePath))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Cant write data to File" + filePath, e);
        }
    }
}
