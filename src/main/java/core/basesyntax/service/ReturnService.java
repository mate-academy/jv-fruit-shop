package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;

public class ReturnService implements ServiceAble {
    @Override
    public void operationWithProduct(Fruit fruit) {
        ListStorage.listStorage.add(fruit);
    }
}
