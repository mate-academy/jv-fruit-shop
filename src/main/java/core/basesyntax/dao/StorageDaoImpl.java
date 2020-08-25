package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StorageDaoImpl implements StorageDao<Fruit> {
    @Override
    public boolean put(Fruit value) {
        boolean successOperation = Storage.FRUIT_LIST.add(value);
        Storage.sortList();
        return successOperation;
    }

    @Override
    public Optional<Fruit> remove(int index) {
        Fruit returnedValue = Storage.FRUIT_LIST.remove(index);
        Storage.sortList();
        return Optional.ofNullable(returnedValue);
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.FRUIT_LIST.isEmpty()
                ? Collections.emptyList()
                : Storage.FRUIT_LIST;
    }
}
