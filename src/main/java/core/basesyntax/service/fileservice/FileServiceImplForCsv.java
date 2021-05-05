package core.basesyntax.service.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImplForCsv implements FileService {
    private static final String WRITE_TO_FILE_EXCEPTION = "Can't write to file: ";

    @Override
    public List<String> readAllLinesFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
    }

    @Override
    public void write(String content, String fileName) {
        try {
            Files.write(Path.of(fileName), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(WRITE_TO_FILE_EXCEPTION + fileName, e);
        }
    }
}
