package core.basesyntax.data.file.impl;

import core.basesyntax.data.file.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    private final Path pathToFile;

    public FileWriterImpl(String pathToFile) {
        this.pathToFile = Path.of(pathToFile);
    }

    @Override
    public void writeAll(List<String> lines) {
        try {
            Files.write(pathToFile, lines); // rewrites, not appends
        } catch (IOException e) {
            throw new RuntimeException("Problems while writing data to file " + pathToFile, e);
        }
    }
}
