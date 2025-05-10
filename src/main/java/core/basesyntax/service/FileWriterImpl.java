package core.basesyntax.service;

import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeData(String report, String fileName) {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            writer.write(report);
        } catch (IOException e) {
            System.err.println("Помилка запису у файл: " + e.getMessage());
        }
    }
}
