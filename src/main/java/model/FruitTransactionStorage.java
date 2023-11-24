package model;

import java.util.List;

public class FruitTransactionStorage {
    private List<FruitTransaction> fruitTransactionList;

    public FruitTransactionStorage(List<FruitTransaction> fruitTransactionList) {
        this.fruitTransactionList = fruitTransactionList;
    }

    public List<FruitTransaction> getFruitTransactionList() {
        return fruitTransactionList;
    }
}
