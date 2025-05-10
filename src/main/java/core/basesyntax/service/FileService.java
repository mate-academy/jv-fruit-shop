package core.basesyntax.service;

public interface FileService {
    String readFromFile(String path);

    void writeToFile(String path, String report);
}
