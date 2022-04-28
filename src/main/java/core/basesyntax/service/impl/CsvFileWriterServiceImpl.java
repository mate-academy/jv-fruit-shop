package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.SeparateService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    private SeparateService separateService = new SeparateServiceImpl();

    @Override
    public void writeToFile(String fileName) {
        File file = new File(fileName);
        List<String> reportFromList = separateService.getReportFromList();
        for (int i = 0; i < reportFromList.size(); i++) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                bufferedWriter.write(reportFromList.get(i));
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file!");
            }
        }
    }
}
