package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeReportToFile(List<String> reportList, String pathToSave) {
        File reportFile = new File(pathToSave);
        for (String line : reportList) {
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(reportFile, true))) {
                writer.write(line);
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file " + reportFile, e);
            }
        }
    }
}
