package core.basesyntax.filewriter;

import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String filePath) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Cant read file by path: " + filePath, e);
        }
    }
}
