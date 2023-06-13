package core.basesyntax.dao;

public interface FruitDao {
    void add(String name, int quantity);

    int get(String name);

    boolean containsFruit(String name);

    String getDataForReportFile();
}
