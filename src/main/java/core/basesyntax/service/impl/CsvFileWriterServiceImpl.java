package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {

    @Override
    public void writeToFile(String pathToFile, String[] report) {
        File file = new File(pathToFile);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (String line: report) {
                writer.write(line);
                writer.write(System.lineSeparator());
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + file.getName(), e);
        }
    }
}
