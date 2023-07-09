package core.basesyntax.handler;

import core.basesyntax.model.Fruit;
import core.basesyntax.utility.FruitType;
import java.util.Map;

public class SupplyOperationHandler implements ShopOperationHandler {
    @Override
    public void doOperation(Map<FruitType, Fruit> fruitMap, String fruitName, String quantity) {
        fruitMap.get(FruitType.valueOf(fruitName.toUpperCase()))
                .addQuantity(Integer.parseInt(quantity));
    }
}
