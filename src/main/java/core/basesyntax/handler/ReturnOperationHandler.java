package core.basesyntax.handler;

import core.basesyntax.model.Fruit;

import java.util.Map;

public class ReturnOperationHandler implements ShopOperationHandler {
    @Override
    public void doOperation(Map<String, Fruit> fruitMap, String fruitName, String quantity) {
        fruitMap.get(fruitName.toLowerCase())
                .addQuantity(Integer.parseInt(quantity));
    }
}
