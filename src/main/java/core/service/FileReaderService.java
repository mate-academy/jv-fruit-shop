package core.service;

import java.util.List;

public interface FileReaderService {
    List<String> readFromFile(String pathToFile);
}
