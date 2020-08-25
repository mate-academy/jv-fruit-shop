package core.basesyntax.controller;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ControllerDao<T extends Fruit> {
    boolean put(T value);

    T get(int index);

    List<T> getAll();
}
