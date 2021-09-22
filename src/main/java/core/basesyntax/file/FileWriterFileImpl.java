package core.basesyntax.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriterFileImpl implements FileWriter {
    private final String writeToFilePath;

    public FileWriterFileImpl(String writeFilePath) {
        this.writeToFilePath = writeFilePath;
    }

    @Override
    public void write(List<String> list) {
        try {
            Files.write(Path.of(writeToFilePath), list, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to " + writeToFilePath);
        }
    }
}
