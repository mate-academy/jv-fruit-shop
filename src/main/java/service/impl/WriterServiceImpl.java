package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeReportToFile(String report, String pathToSave) {
        File reportFile = new File(pathToSave);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile, true))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + reportFile, e);
        }

    }
}
