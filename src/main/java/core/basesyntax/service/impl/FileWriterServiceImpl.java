package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class FileWriterServiceImpl implements FileWriterService {
    private final Path path;

    public FileWriterServiceImpl(Path path) {
        this.path = path;
    }

    @Override
    public void writeReportToFile(String report) {
        Path fileName =
                Path.of(path.toString()
                        + File.separator
                        + "report-"
                        + LocalDateTime.now()
                        + ".csv");
        try {
            Files.createFile(fileName);
            Files.write(fileName,report.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't create file at " + path, e);
        }
    }
}
