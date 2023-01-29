package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteServiceImpl implements WriterService {
    private static final String fileName = "src/main/resources/result.csv";

    @Override
    public void writeToFile() {
        StringBuilder results = new StringBuilder("fruit,quantity" + System.lineSeparator());
        Storage.fruits.entrySet().stream()
                .forEach(f -> results.append(f.getKey()).append(",")
                        .append(f.getValue()).append(System.lineSeparator()));
        try {
            Files.write(Path.of(fileName),results.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write result file");
        }
    }
}
