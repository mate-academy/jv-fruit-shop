package services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import services.interfaces.FileReader;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFile(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.map(String::trim).collect(Collectors.toList());
        }
    }
}
