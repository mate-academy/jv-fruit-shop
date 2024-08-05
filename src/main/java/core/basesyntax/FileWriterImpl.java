package core.basesyntax;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(data))) {
            bufferedWriter.write(filePath);
        } catch (IOException e) {
            throw new RuntimeException("can not write to file: " + filePath, e);
        }
    }
}
