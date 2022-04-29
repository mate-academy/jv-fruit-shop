package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.ReportService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {

    @Override
    public void writeToFile(String fileName, ReportService reportService) {
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(reportService.createReport());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file!");
        }
    }
}
