package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReaderInterface {
    private static final int FIRST_LINE_SKIP = 1;

    @Override
    public List<String> read(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        try (Stream<String> lines = Files.lines(Path.of(filePath))) {
            return lines.skip(FIRST_LINE_SKIP)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + filePath, e);
        }
    }
}
