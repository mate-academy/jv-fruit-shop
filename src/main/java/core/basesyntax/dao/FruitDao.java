package core.basesyntax.dao;

public interface FruitDao {
    void readFromDb(String filePath);

    void writeToReport(String reportPath);
}
