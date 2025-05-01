package core.basesyntax.file.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriterInterface {
    @Override
    public void write(String report, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(report);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error generating file " + filePath, e);
        }
    }
}
