package core.basesyntax.dao;

public interface FileService {
    String readFile(String fileName);

    void writeToFile(String report, String fileName);
}
