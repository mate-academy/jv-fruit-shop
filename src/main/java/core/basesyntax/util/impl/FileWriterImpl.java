package core.basesyntax.util.impl;

import core.basesyntax.util.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    private final String filePath;

    public FileWriterImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeToFile(List<String> lines) {
        Path pathToFile = Path.of(filePath);
        try {
            for (int i = 0; i < lines.size(); i++) {
                if (i == 0) {
                    Files.write(pathToFile, lines.get(i).getBytes());
                    continue;
                }
                Files.write(pathToFile, lines.get(i).getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + pathToFile);
        }
    }
}
