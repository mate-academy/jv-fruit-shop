package core.basesyntax.service.impl;

import core.basesyntax.service.FileDao;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileDaoImpl implements FileDao {
    private static final String COLUMNS = "fruit,quantity";

    @Override
    public List<String> getData(String filePath) {
        File file = new File(filePath);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read", e);
        }
    }

    @Override
    public void writeData(String newFilePath, List<String> statistic) {
        Path path = new File(newFilePath).toPath();
        try {
            Files.write(path, COLUMNS.getBytes());
            for (String line : statistic) {
                String separateLine = System.lineSeparator() + line;
                Files.write(path, separateLine.getBytes(), StandardOpenOption.APPEND);

            }
        } catch (IOException e) {
            throw new RuntimeException("Cant write to file", e);
        }
    }
}
