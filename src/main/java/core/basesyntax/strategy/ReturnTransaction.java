package core.basesyntax.strategy;

import core.basesyntax.FruitBatch;
import core.basesyntax.FruitDto;
import core.basesyntax.FruitStorage;
import java.util.Map;

public class ReturnTransaction implements FruitTransaction {

    @Override
    public void apply(FruitDto fruitDto) {
        Map<FruitBatch, Integer> fruitStorage = FruitStorage.getFruits();
        FruitBatch fruit = new FruitBatch(fruitDto.getFruitType(), fruitDto.getDate());
        int quantity = fruitDto.getQuantity();
        if (fruitStorage.containsKey(fruit)) {
            fruitStorage.put(fruit,
                    fruitStorage.get(fruit) + quantity);
        } else {
            fruitStorage.put(fruit, quantity);
        }
    }
}
