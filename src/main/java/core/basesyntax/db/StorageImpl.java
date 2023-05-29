package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class StorageImpl implements Storage {
    @Override
    public void update(FruitTransaction fruitTransaction, int count) {
        Storage.storage.put(fruitTransaction.getFruit(), count);
    }

    @Override
    public int calculateAmount(FruitTransaction fruitTransaction) {
        return Storage.storage.getOrDefault(fruitTransaction.getFruit(), 0);
    }

    @Override
    public List<String> getAll() {
        String joiningSymbol = ",";
        return Storage.storage.entrySet().stream()
                .map(entry -> entry.getKey() + joiningSymbol + entry.getValue())
                .collect(Collectors.toList());
    }
}
