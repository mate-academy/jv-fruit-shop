package core.service.impl;

import core.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    private static final String REPORT_FILEPATH = "src/main/java/resources/report.csv";

    @Override
    public void writeTo(List<String> list) {
        try {
            Files.write(Path.of(REPORT_FILEPATH), list);
        } catch (IOException e) {
            throw new RuntimeException("Can't write information to the file.", e);
        }
    }
}
