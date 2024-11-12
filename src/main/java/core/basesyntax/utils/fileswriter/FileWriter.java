package core.basesyntax.utils.fileswriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter implements IFileWriter {
    @Override
    public void writeToFile(Path path, byte[] content) {
        try {
            Files.write(path, content);
        } catch (IOException e) {
            throw new RuntimeException("Error while writing to file", e);
        }
    }
}
