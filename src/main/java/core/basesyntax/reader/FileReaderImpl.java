package core.basesyntax.reader;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<String> read(String source) {
        if (source == null || source.trim().isEmpty()) {
            throw new IllegalArgumentException("source must not"
                    + " be null or blank");
        }
        final Path path;
        try {
            path = Paths.get(source);
        } catch (InvalidPathException e) {
            throw new IllegalArgumentException("Invalid path: "
                    + source, e);
        }
        try {
            List<String> lines = Files.readAllLines(path);
            if (lines.isEmpty()) {
                return List.of();
            }
            boolean firstIsHeader = lines.get(0).trim()
                    .equalsIgnoreCase(HEADER);

            Stream<String> stream = lines.stream();
            if (firstIsHeader) {
                stream = stream.skip(1);
            }
            return stream
                    .map(String::trim)
                    .filter(l -> !l.isEmpty())
                    .filter(l -> !l.equalsIgnoreCase(HEADER))
                    .toList();

        } catch (IOException e) {
            throw new UncheckedIOException("Error reading file "
                    + source, e);
        }
    }
}
