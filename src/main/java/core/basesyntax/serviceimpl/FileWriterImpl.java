package core.basesyntax.serviceimpl;

import core.basesyntax.service.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(List<String> lines, String path) {
        if (lines == null) {
            throw new RuntimeException("Lines can`t be null!");
        }
        if (path == null) {
            throw new RuntimeException("Path can`t be null!");
        }

        try {
            Files.write(Path.of(path), lines);
        } catch (Exception e) {
            throw new RuntimeException("Cannot write file: " + path, e);
        }
    }
}
