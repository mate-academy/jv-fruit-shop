package core.basesyntax.service;

import java.util.List;

public interface FileService {
    public List<String> readFile(String fileName);

    public void writeToFile(String fileName, String report);
}
