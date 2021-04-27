package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface MagazineDao {
    Fruit getFruit(String fruitName);

    void updateQuantity(Fruit fruit);
}
