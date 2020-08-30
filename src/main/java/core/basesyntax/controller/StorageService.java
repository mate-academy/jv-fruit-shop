package core.basesyntax.controller;

import core.basesyntax.model.Product;
import java.util.List;

public interface StorageService<T extends Product> {
    boolean put(T value);

    T get(int index);

    List<T> getAll();
}
