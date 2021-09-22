package core.basesyntax.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class WriterFileImpl implements Writer {
    private final String writeToFilePath;

    public WriterFileImpl(String writeFilePath) {
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
