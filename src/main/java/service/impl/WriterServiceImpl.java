package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String PATH_TO_SAVE = "src/main/resources/report_file.csv";

    @Override
    public void writeReportToFile(List<String> reportList) {
        File reportFile = new File(PATH_TO_SAVE);
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
