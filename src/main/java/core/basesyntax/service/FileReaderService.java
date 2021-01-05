package core.basesyntax.service;

import java.util.List;

public interface FileReaderService {
    String readFromFile(String filepath);

    List<String> getDataFromFile(String filePath);
}
