package core.basesyntax.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReaderService {

    @Override
    public List<String> read(String path) {
        if (path == null || path.isEmpty()) {
            throw new RuntimeException("Path doesn't exist");
        }

        List<String> stringLines = new ArrayList<>();

        try {
            stringLines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("File doesn't exist or is unreadable.", e);
        }
        return stringLines;
    }
}
