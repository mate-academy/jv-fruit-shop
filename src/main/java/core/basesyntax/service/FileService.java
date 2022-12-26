package core.basesyntax.service;

public interface FileService {
    String readFromFile(String fromFileName);

    void writeToFile(String toFileName, String data);
}
