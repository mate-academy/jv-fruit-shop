package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriterService;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriterServiceImpl implements DataWriterService {

    @Override
    public void writeToFile(String content, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file " + fileName, e);
        }
    }
}
