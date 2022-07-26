package core.basesyntax.dao;

public interface FruitsDao {
    void add(String product, int quantity);
    void plus(String product, int quantity);
    void subtract(String product, int quantity);
    int getAmount(String product);
    String[] getFruitsNames();
}
