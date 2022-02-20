package core.basesyntax.files;

public interface FileService {
    String readData(String absolutePath);

    void writeData(String listOfFruits, String absoluteFilePath);
}
