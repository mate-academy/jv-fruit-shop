package core.basesyntax.strategy;

import core.basesyntax.dao.impl.Storage;

public interface ExistFruit {
    default boolean existFruit(String fruit) {
        return !Storage.fruits.containsKey(fruit);
    }
}
