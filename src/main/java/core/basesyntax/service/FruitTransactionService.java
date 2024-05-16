package core.basesyntax.service;

public interface FruitTransactionService {
    void createNewFruitTransaction(String type, String fruit, int quantity);

    int getFruitCount(String fruit);
}
