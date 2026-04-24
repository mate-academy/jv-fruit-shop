package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeFile(List<String> lines, String path) {
        try {
            Files.write(Path.of(path), lines);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file: " + path, e);
        }
    }
}
