package core.basesyntax.service;

import core.basesyntax.model.Grid;

public interface GridGeneratorService<T> {
    Grid grid(T value);
}
