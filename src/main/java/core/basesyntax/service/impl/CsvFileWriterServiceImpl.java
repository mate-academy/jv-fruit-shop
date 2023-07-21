package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void write(String report) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter("src/main/resources/output.csv"))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report in file((");
        }
    }
}
