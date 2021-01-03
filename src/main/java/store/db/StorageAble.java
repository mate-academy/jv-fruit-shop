package store.db;

import store.model.Fruits;

public interface StorageAble {
    void add(Actions key, Fruits value);
}
