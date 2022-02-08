package fruite.store.service;

import fruite.store.model.FruitTransaction;

public interface Storage {
    void addFruiteToList(FruitTransaction fruitTransaction);
}
