package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitOperations;
import java.util.Map;

public class ReturnFruitOperation implements FruitOperations {
    private Map<String, Fruit> storage = Fruit.getFruitStorage();

    @Override
    public void doOperation(FruitDto fruitDto) {
        String fruitName = fruitDto.getFruitName();
        Integer amountToReturn = fruitDto.getAmount();
        Fruit fruit;
        if (storage.containsKey(fruitName)) {
            fruit = new SupplyFruitOperation().getFruit(fruitDto, fruitName, amountToReturn);
            if (fruit == null) {
                return;
            }
        } else {
            throw new RuntimeException("You can not return this fruit");
        }
    }
}
