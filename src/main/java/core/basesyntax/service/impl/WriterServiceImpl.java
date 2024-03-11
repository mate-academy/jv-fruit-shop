package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public boolean createWriteCsv(String pathFile, String data) {

        if (data.isBlank()) {
            throw new RuntimeException("Data to write aren`t correct");
        }
        if (pathFile.isBlank()) {
            throw new RuntimeException("Path file is empty");
        }
        try (FileWriter writer = new FileWriter(pathFile)) {
            writer.write(data);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can`t write file by this path: " + pathFile + " " + e);
        }
    }
}
