package serviceimpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FileReader;

public class ReadFileImpl implements FileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file " + fileName, e);
        }
        return lines;
    }
}
