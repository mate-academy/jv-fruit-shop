package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvWriter implements WriterService {
    private String title;

    public CsvWriter(String title) {
        this.title = title;
    }

    @Override
    public void saveToFile(String filePath, String linesToFile) {
        Path path = Path.of(filePath);
        if (!Files.isReadable(path)) {
            createNewFile(path);
        }
        if (title != null) {
            linesToFile = title + System.lineSeparator() + linesToFile;
        }
        try {
            Files.write(path,linesToFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file", e);
        }
    }

    private void createNewFile(Path filePath) {
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can`t found or create file", e);
        }
    }
}
