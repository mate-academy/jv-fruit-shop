package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReportWriterServiceImpl implements ReportWriterService {
    @Override
    public void writeReport(String report, String filePath) {
        try {
            Files.write(Paths.get(filePath), new ReportCreatorServiceImpl()
                    .createReport().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file" + e);
        }
    }
}
