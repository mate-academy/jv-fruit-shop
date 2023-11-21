package impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReadFileService;

public class ReadFileImpl implements ReadFileService {
    public static final int HEADER_INDEX = 0;

    @Override
    public List<String> readFile(String filePath) {
        List<String> file;
        try {
            file = Files.readAllLines(Path.of(filePath));
            file.remove(HEADER_INDEX);
            return file;
        } catch (IOException e) {
            throw new RuntimeException("Can not read data from file " + filePath, e);
        }
    }
}
