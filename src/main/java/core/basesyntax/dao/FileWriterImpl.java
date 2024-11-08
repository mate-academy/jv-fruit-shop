package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String info, String nameOfFileForFinalReport) {
        try (BufferedWriter writer = new BufferedWriter(
                new java.io.FileWriter(nameOfFileForFinalReport))) {
            writer.write(info);
        } catch (IOException e) {
            throw new RuntimeException("File was not created", e);
        }
    }
}
