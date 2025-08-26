package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.CsvFileWriter;

public class CsvFileWriterImpl implements CsvFileWriter {
    @Override
    public void write(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + filePath, e);
        }

    }
}
