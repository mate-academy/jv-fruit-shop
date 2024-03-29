package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeDataToFile(String data, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(Path.of(filePath).toFile());
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + filePath, e);
        }
    }
}
