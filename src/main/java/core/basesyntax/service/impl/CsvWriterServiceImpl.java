package core.basesyntax.service.impl;

import core.basesyntax.service.CsvWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterServiceImpl implements CsvWriterService {
    @Override
    public void writeToFile(String path, String outputData) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(outputData);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file", e);
        }
    }
}
