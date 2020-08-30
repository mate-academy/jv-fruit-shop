package core.basesyntax.dao;

import core.basesyntax.model.Product;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StorageDaoImpl implements StorageDao<Product> {
    @Override
    public boolean put(Product value) {
        boolean successOperation = Storage.getFruitList().add(value);
        Storage.sortList();
        return successOperation;
    }

    @Override
    public Optional<Product> retrieve(int index) {
        Product returnedValue = Storage.getFruitList().remove(index);
        Storage.sortList();
        return Optional.ofNullable(returnedValue);
    }

    @Override
    public List<Product> getAll() {
        return Storage.getFruitList().isEmpty()
                ? Collections.emptyList()
                : Storage.getFruitList();
    }
}
