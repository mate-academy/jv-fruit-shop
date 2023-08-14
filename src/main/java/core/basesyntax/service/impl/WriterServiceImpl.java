package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.io.PrintWriter;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String report, String fileName) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            printWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName);
        }
    }
}
