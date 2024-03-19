package core.basesyntax.serviceImpl;

import core.basesyntax.service.StorageService;
import core.basesyntax.db.Storage;

import java.util.Map;

public class StorageServiceImpl implements StorageService {

    private static final Storage storage = new Storage();

    @Override
    public void add(String name, Integer quantity) {

    }

    @Override
    public Integer get(String key) {
        return null;
    }

    @Override
    public Map<String, Integer> getAll() {
        return null;
    }

    @Override
    public void update(String name, Integer value) {

    }
}