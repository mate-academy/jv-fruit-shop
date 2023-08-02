package core.basesyntax.service.implementation;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String report, File reportFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't find a file " + reportFile.getName(),e);
        }
    }
}
