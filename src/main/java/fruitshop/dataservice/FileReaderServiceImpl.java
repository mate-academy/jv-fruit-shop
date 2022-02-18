package fruitshop.dataservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> getDataFromFile(String file) {
        List<String> readData;
        try {
            readData = Files.readAllLines(Path.of(file));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file" + e);
        }
        return readData;
    }
}
