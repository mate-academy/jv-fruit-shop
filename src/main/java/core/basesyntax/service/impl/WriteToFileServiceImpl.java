package core.basesyntax.service.impl;

import core.basesyntax.service.WriterToFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFileServiceImpl implements WriterToFileService {
    private static final String FILE_REPORT = "src/main/resources/output.csv";

    @Override
    public void writeReportToFile(String report) {
        try {
            Files.writeString(Path.of(FILE_REPORT), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + FILE_REPORT, e);
        }
    }
}
