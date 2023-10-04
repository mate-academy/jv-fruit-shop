package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> readFromFile(String fromFile);

    void writeToFile(String toFile, String content);

}
