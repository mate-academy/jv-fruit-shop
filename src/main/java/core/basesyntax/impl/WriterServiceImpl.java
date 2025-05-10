package core.basesyntax.impl;

import core.basesyntax.service.WriterService;
import java.io.FileWriter;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String report, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(report);
        } catch (Exception e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
    }
}
