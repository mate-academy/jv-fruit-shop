package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class CsvWriterServiceImpl implements WriterService {
    private static final String FILE_PATH = "src/main/resources/report.csv";

    @Override
    public void writeToFile(String data) {
        String dataString = new StringBuilder().append("fruit,quantity")
                .append(System.lineSeparator())
                .append(data).toString();

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Can't create file", e);
            }
        }
        try {
            Files.write(file.toPath(), dataString.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
