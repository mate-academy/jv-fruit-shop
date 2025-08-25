package core.basesyntax.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReaderService {

    @Override
    public List<String> read(String path) {
        List<String> stringLines = new ArrayList<>();

        try {
            stringLines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringLines;
    }
}
