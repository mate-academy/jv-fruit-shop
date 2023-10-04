package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {

    @Override
    public void writeToFile(String fileName, String data) {
        File file = new File(fileName);
        try {
            Files.write(file.toPath(), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file with name: " + file.getName());
        }
    }
}
