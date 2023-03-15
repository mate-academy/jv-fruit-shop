package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class FileWriterServiceImpl implements FileWriterService {
    private final String path;

    public FileWriterServiceImpl(String path) {
        this.path = path;
    }

    @Override
    public void writeReportToFile(String report) {
        String fileName = "report-" + LocalDateTime.now() + ".csv";
        File fileReport = new File(path + fileName);
        try {
            fileReport.createNewFile();
            Files.write(fileReport.toPath(),report.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
