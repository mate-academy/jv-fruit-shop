package core.basesyntax.service;

import core.basesyntax.products.Fruit;

public class ReturnService implements Handleable {
    @Override
    public void operationWithProduct(Fruit fruit) {
        SupplyService supplyService = new SupplyService();
        supplyService.operationWithProduct(fruit);
    }
}
