package core.basesyntax.service.dao;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String fileName) {
        String[] lines = report.split("\n");
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {
            for (int i = 0; i < lines.length; i++) {
                writer.write(lines[i]);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
