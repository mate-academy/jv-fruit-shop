package service.filework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GetDataFromFileImpl implements GetDataFromFile {

    @Override
    public List<String> getFromStorage(String filePath) {
        List<String> fruits;
        try {
            fruits = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Sorry can't find fruit ",e);
        }
        return fruits;
    }
}

