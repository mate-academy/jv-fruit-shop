package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    public File writetoFile(String report) {
        File reportFile = new File("Report.csv");
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(reportFile, true))) {
            writer.write(report);
        } catch (IOException ex) {
            throw new RuntimeException("Can't write to file", ex);
        }
        return reportFile;
    }
}
