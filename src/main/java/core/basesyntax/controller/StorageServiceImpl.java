package core.basesyntax.controller;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Product;
import java.util.List;

public class StorageServiceImpl implements StorageService<Product> {
    private StorageDao<Product> storageDao;

    public StorageServiceImpl(StorageDao<Product> storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public boolean put(Product value) {
        if (value == null) {
            return false;
        }
        return storageDao.put(value);
    }

    @Override
    public Product get(int index) {
        if (storageDao.getAll().size() <= index
                || index < 0) {
            throw new IllegalArgumentException();
        }
        return storageDao.retrieve(index).orElseThrow();
    }

    @Override
    public List<Product> getAll() {
        return storageDao.getAll();
    }
}
