package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterService implements FileWriterService {
    private static final String DEFAULT_NAME = "report.csv";

    @Override
    public void writeToFile(String path, String report) {
        File fileReport = new File(path + DEFAULT_NAME);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileReport))) {
            fileReport.createNewFile();
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't create a new report!");
        }
    }
}
