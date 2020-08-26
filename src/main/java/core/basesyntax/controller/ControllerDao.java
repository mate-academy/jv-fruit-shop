package core.basesyntax.controller;

import core.basesyntax.model.Product;
import java.util.List;

public interface ControllerDao<T extends Product> {
    boolean put(T value);

    T get(int index);

    List<T> getAll();
}
