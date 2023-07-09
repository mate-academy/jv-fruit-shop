package core.basesyntax.handler;

import core.basesyntax.model.Fruit;

import java.util.Map;

public class PurchaseOperationHandler implements ShopOperationHandler {

    @Override
    public void doOperation(Map<String, Fruit> fruitMap, String fruitName, String quantity) {
        fruitMap.get(fruitName.toLowerCase())
                .subtractQuantity(Integer.parseInt(quantity));
    }
}
