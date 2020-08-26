package core.basesyntax.dao;

import core.basesyntax.model.Product;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StorageDaoImpl implements StorageDao<Product> {
    @Override
    public boolean put(Product value) {
        boolean successOperation = Storage.FRUIT_LIST.add(value);
        Storage.sortList();
        return successOperation;
    }

    @Override
    public Optional<Product> remove(int index) {
        Product returnedValue = Storage.FRUIT_LIST.remove(index);
        Storage.sortList();
        return Optional.ofNullable(returnedValue);
    }

    @Override
    public List<Product> getAll() {
        return Storage.FRUIT_LIST.isEmpty()
                ? Collections.emptyList()
                : Storage.FRUIT_LIST;
    }
}
