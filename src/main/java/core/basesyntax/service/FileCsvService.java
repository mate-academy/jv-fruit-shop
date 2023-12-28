package core.basesyntax.service;

import java.util.List;

public interface FileCsvService {

    List<String> readFile(String path);

    void writeToFile(String path, List<String> data);
}
