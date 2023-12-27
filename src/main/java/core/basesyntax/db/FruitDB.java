package core.basesyntax.db;

public interface FruitDB {
    int getQuantity(String fruit);

    void setQuantity(String fruit, int quantity);
}
