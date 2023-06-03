package core.basesyntax.service.impl;

import core.basesyntax.service.WriteReportToFileService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReportToFileServiceImpl implements WriteReportToFileService {
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();

    @Override
    public void writeReportToFile(String reportText, File toFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(TITLE);
            bufferedWriter.write(reportText);
        } catch (IOException e) {
            throw new RuntimeException("can't write data to file: " + toFile);
        }
    }
}
