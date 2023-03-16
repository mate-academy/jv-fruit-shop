package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeReportToFile(String report, String path) {
        Path fileName =
                Path.of(path
                        + File.separator
                        + "report-"
                        + ".csv");
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(fileName.toFile()))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't create file at " + path, e);
        }
    }
}
