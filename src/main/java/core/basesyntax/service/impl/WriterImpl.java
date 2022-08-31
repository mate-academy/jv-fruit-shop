package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterImpl implements Writer {
    @Override
    public void writeToFile(String report, String reportFileName) {
        try {
            Files.write(Path.of(reportFileName), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't create file: " + reportFileName, e);
        }
    }
}
