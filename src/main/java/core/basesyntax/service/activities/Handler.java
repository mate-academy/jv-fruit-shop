package core.basesyntax.service.activities;

import core.basesyntax.model.Fruit;

public interface Handler {
    Fruit createFruitObject(String[] record);
}
