package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void fileWrite(String report, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Sorry can't add data to" + fileName, e);
        }
    }
}
