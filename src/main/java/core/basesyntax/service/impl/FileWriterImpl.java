package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    private static final String COLUMNS = "fruit,quantity";

    @Override
    public void writeLines(String filePath, List<String> records) {
        Path path = new File(filePath).toPath();
        try {
            Files.write(path, COLUMNS.getBytes());
            for (String line : records) {
                String separateLine = System.lineSeparator() + line;
                Files.write(path, separateLine.getBytes(), StandardOpenOption.APPEND);

            }
        } catch (IOException e) {
            throw new RuntimeException("Cant write to file", e);
        }
    }
}
