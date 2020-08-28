package core.basesyntax.service;

import java.util.List;

public interface FileService {

    List<String[]> fileReader(String filePath);

    void fileWriter(String filePath, List<String> output);
}
