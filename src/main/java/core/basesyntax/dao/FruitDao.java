package core.basesyntax.dao;

public interface FruitDao {
    Integer add(String fruitName, int amount);

    boolean writeReportToFile(String fileName, String report);

    String createReport();
}
