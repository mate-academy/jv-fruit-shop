package core.basesyntax.controller;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import java.util.List;

public class ControllerDaoImpl implements ControllerDao<Fruit> {
    private StorageDao<Fruit> storageDao = new StorageDaoImpl();

    @Override
    public boolean put(Fruit value) {
        if (value == null) {
            return false;
        }
        return storageDao.put(value);
    }

    @Override
    public Fruit get(int index) {
        if (storageDao.getAll().size() <= index
                || index < 0
                || storageDao.getAll().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return storageDao.remove(index).orElseThrow();
    }

    @Override
    public List<Fruit> getAll() {
        return storageDao.getAll();
    }
}
