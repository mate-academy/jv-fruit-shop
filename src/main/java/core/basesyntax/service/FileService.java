package core.basesyntax.service;

public interface FileService {
    String readFile(String filePath);

    void writeDataToFile(String filePath, String data);
}
