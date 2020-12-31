package core.basesyntax.service;

public interface FileReaderService {
    String readFromFile();

    String[] getDataFromFile(String filePath);
}
