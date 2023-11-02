package core.basesyntax.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriter implements FileWriterService {
    @Override
    public boolean writeToFile(String report, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(report);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + filePath, e);
        }
    }
}
