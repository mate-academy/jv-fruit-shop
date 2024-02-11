package core.basesyntax.util.impl;

import core.basesyntax.util.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    private String filePath;

    public FileWriterImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeToFile(List<String> lines) {
        Path pathToFile = Path.of(filePath);
        String firstLineReport = "fruit, quantity" + System.lineSeparator();
        try {
            Files.write(pathToFile, (firstLineReport).getBytes());
            for (String line : lines) {
                Files.write(pathToFile, (line + System.lineSeparator()).getBytes(),
                        StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + pathToFile);
        }
    }
}
