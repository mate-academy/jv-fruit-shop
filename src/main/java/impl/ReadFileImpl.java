package impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import service.ReadFileService;

public class ReadFileImpl implements ReadFileService {
    @Override
    public List<String> readFile(String filePath) {
        List<String> file = new ArrayList<>();
        try {
            file = Files.readAllLines(Path.of(filePath));
            return file;
        } catch (IOException e) {
            throw new RuntimeException("Can not read data from file " + filePath, e);
        }
    }
}
