package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImp implements ReaderService {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> activitiesLines;
        try {
            activitiesLines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from the file!", e);
        }
        return activitiesLines;
    }
}
