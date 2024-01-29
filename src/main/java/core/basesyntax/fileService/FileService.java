package core.basesyntax.fileService;

public interface FileService {
    String readFile(String fileName);

    void writeToFile(String currentData, String fileName);
}
