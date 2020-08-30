package core.basesyntax.storeservice;

import core.basesyntax.goods.FruitPack;

public interface Operation {
    boolean updateStorage(FruitPack product);
    boolean equals(Object o);
}
