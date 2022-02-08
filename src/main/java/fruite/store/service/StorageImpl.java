package fruite.store.service;

import fruite.store.model.FruitTransaction;

import java.util.ArrayList;
import java.util.List;

public class StorageImpl implements Storage {
    public List<FruitTransaction> fruitTransactionList = new ArrayList<>();
    @Override
    public void addFruiteToList(FruitTransaction fruitTransaction) {
        fruitTransactionList.add(fruitTransaction);
    }
}
