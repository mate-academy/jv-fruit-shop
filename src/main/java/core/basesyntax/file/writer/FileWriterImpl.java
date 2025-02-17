package core.basesyntax.file.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriterInterface {
    @Override
    public void write(String report, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(report);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error generating file " + fileName, e);
        }
    }
}
