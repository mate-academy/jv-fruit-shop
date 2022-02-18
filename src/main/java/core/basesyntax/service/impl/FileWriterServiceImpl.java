package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String SIGN = ",";
    private String reportFile = "fruit,quantity";
    private final StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void write(String reportFilePath, List<Fruit> fruitsFromStorage) {
        for (Fruit fruit : fruitsFromStorage) {
            stringBuilder.append(System.lineSeparator())
                   .append(fruit.getFruitType()).append(SIGN).append(fruit.getAmount());
        }
        reportFile += stringBuilder.toString();
        try {
            Files.write(Paths.get(reportFilePath), reportFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t rite file by the path " + reportFilePath, e);
        }
    }
}
