package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;

public class SupplyService implements ServiceAble {
    @Override
    public void operationWithProduct(Fruit fruit) {
        ListStorage.listStorage.add(fruit);
    }
}
