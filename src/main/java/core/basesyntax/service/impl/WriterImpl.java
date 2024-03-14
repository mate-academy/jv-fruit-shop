package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterImpl implements Writer {
    @Override
    public void writeToFolder(String report, String pathToFile) {
        Path path = Path.of(pathToFile);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file. File=" + pathToFile, e);
        }

    }
}
