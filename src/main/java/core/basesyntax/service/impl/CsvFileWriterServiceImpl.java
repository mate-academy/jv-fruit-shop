package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {

    @Override
    public void writeDataToFile(String filename, String data) {
        try {
            Files.write(Paths.get(filename), data.getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("It's not possible to write data to file " + filename, e);
        }
    }
}
