package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> readFile(String inputDataFile);

    void writeToFile(String report, String outputDataFile);
}
