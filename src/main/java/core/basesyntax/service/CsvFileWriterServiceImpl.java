package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String pathToFile, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + pathToFile, e);
        }
    }
}
