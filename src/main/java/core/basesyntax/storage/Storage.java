package core.basesyntax.storage;

public interface Storage {
    void saveItem(String item, int quantity);

    void supplyItem(String item, int quantity);

    void purchaseItem(String item, int quantity);

    int getAmount(String item);
}
