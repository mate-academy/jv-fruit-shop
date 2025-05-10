package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String path, List<String> report) {
        try (FileWriter writer = new FileWriter(path)) {
            for (String line : report) {
                writer.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + path);
        }
    }
}
