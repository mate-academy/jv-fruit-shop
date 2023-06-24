package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {

    private String reportFilePath;

    public WriterServiceImpl(String reportFilePath) {
        if (reportFilePath == null) {
            throw new RuntimeException("File path can not be null.");
        }
        this.reportFilePath = reportFilePath;
    }

    @Override
    public void write(String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(new File(reportFilePath))
        )) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("IOException when write to " + reportFilePath, e);
        }
    }
}
