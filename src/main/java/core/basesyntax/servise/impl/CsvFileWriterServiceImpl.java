package core.basesyntax.servise.impl;

import core.basesyntax.servise.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements WriterService {
    public static final String FILE_PATH = "src/main/resources/report.txt";

    @Override
    public void writeToFile(String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + FILE_PATH, e);
        }
    }
}
