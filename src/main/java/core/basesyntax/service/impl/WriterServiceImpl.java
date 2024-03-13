package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String pathFile, String data) {
        try (FileWriter writer = new FileWriter(pathFile)) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write file by this path: " + pathFile, e);
        }
    }
}
