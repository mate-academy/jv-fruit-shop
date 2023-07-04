package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriterService {
    @Override
    public void writeReportToFile(String content, String reportFileName) {
        try (FileWriter writer = new FileWriter(reportFileName)) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: ", e);
        }
    }
}
