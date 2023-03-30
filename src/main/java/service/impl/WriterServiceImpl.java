package service.impl;

import db.Storage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String NAME_FILE = "src/main/resources/report.csv";
    private static final String FILE_HEAD = "fruit,quantity";

    @Override
    public void getReport() {
        try {
            Path pathFile = Path.of(NAME_FILE);
            Files.write(pathFile, (FILE_HEAD + System.lineSeparator()).getBytes());
            for (Map.Entry<String, Integer> fruitEntry : Storage.fruits.entrySet()) {
                Files.write(pathFile, (fruitEntry.getKey() + ","
                        + fruitEntry.getValue()
                        + System.lineSeparator())
                        .getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + NAME_FILE, e);
        }
    }
}
