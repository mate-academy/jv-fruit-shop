package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListShopStorage;

public class SupplyService implements Servicing {
    @Override
    public void serviceProduct(Fruit fruit) {
        ListShopStorage.listStorage.add(fruit);
    }
}
