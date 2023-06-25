package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeReportToFile(String path, String reportData) {
        try (Writer writer = new FileWriter(path)) {
            writer.append(reportData);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + path);
        }
    }
}
