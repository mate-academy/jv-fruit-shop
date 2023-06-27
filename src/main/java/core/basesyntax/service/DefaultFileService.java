package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DefaultFileService implements FileService {
    @Override
    public String readFile(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Cannot read file '%s'", filePath), e);
        }
    }

    @Override
    public void writeDataToFile(String filePath, String data) {
        try {
            Files.write(Path.of(filePath), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Cannot write data to file '%s'", filePath), e
            );
        }
    }
}
