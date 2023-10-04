package core.basesyntax.service.implementation;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String report, String reportFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't find a file " + reportFile, e);
        }
    }
}
