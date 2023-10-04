package core.basesyntax.fileserve;

public interface FileService {
    String getFruitData(String fromFile);

    void writeToFile(String fruitReport, String toFile);
}
