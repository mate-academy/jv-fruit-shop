package core.basesyntax.service.operationwithdata;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.fruitmodel.Fruit;
import core.basesyntax.fruitstorage.FruitStorage;
import java.util.Optional;

public class AddOperation implements FruitOperationService {
    @Override
    public int apply(FruitDto fruitDto) {
        Fruit fruit = new Fruit(fruitDto.getFruitName());
        Optional<Integer> currentQuantityFruit =
                Optional.ofNullable(FruitStorage.fruitStorage.get(fruit));
        if (currentQuantityFruit.isPresent()) {
            int newBalance = currentQuantityFruit.get() + fruitDto.getCountFruit();
            FruitStorage.fruitStorage.put(fruit, newBalance);
            return newBalance;
        } else {
            FruitStorage.fruitStorage.put(fruit, fruitDto.getCountFruit());
            return fruitDto.getCountFruit();
        }
    }
}

