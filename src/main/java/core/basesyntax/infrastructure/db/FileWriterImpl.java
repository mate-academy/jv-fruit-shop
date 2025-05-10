package core.basesyntax.infrastructure.db;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultingReport, String fileName) {
        try (BufferedWriter br = new BufferedWriter(new java.io.FileWriter(fileName))) {
            br.write(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't open the file: " + fileName, e);
        }
    }
}
