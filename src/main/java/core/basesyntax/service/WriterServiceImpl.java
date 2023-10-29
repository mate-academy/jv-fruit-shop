package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    public void writetoFile(String report, String pathName) {
        File reportFile = new File(pathName);
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(reportFile, true))) {
            writer.write(report);
        } catch (IOException ex) {
            throw new RuntimeException("Can't write to file", ex);
        }
    }
}
