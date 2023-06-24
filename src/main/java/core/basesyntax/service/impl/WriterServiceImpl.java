package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeDataToFile(String data, String filePath) {
        File inputFile = new File(filePath);
        try {
            Files.write(inputFile.toPath(), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + inputFile.getName(), e);
        }
    }
}
