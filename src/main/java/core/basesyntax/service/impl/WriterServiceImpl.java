package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String path, List<String> report) {
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            for (String line : report) {
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + path);
        }
    }
}
