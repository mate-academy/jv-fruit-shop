package service;

import db.Storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterService implements FileWriterService {
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public void saveToFile(File report) {
        Storage.storage.entrySet().stream()
                .forEach(f -> write(report, f.getKey(), f.getValue()));
    }

    private void write(File report, String fruit, Integer amount) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(report, true))) {
            bufferedWriter.write(fruit + COMMA_SEPARATOR
                    + amount + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can’t write data to file", e);
        }
    }
}
