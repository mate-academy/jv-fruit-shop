package core.basesyntax.model;

import core.basesyntax.model.entities.Product;

public interface Executable<T extends Product> {
    void execute(T product, Integer amount);
}
