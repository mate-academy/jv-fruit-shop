package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderImpl implements Reader {
    @Override
    public String read(String fileName) {
        List<String> lines;
        String line;
        try {
            lines = Files.readAllLines(Path.of(fileName));
            line = lines.stream().skip(1).collect(Collectors.joining());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file." + fileName);
        }
        return line;
    }
}
