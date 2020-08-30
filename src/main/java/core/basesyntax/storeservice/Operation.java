package core.basesyntax.storeservice;

import core.basesyntax.dao.FruitStorage;
import core.basesyntax.goods.FruitPack;

public interface Operation {
    boolean updateStorage(FruitPack product, FruitStorage storage);
    boolean equals(Object o);
}
