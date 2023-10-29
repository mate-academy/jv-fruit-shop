package core.basesyntax.db;

public interface StorageDao {
    boolean increaseFruitsAmount(String fruit, int quantity);

    boolean decreaseFruitsAmount(String fruit, int quantity);

    boolean addNewFruit(String fruit, int quantity);

    boolean isInStorage(String fruit);

    int getAmountOf(String fruit);
}
