package reader.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderImpl implements Reader {

    @Override
    public List<String> read(String filepath) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filepath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + filepath);
        }
        return lines;
    }
}
