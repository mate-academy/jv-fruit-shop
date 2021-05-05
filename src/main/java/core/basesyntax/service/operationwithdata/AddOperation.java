package core.basesyntax.service.operationwithdata;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.fruitmodel.Fruit;
import core.basesyntax.fruitstorage.FruitStorage;
import java.util.Optional;

public class AddOperation implements FruitOperationService {
    @Override
    public int apply(FruitDto fruitDto) {
        Fruit fruit = new Fruit(fruitDto.getFruitName());
        FruitStorage fruitStorage = new FruitStorage();
        Optional<Integer> currentQuantityFruit =
                Optional.ofNullable(fruitStorage.get(fruit));
        if (currentQuantityFruit.isPresent()) {
            int newBalance = currentQuantityFruit.get() + fruitDto.getCountFruit();
            fruitStorage.save(fruit, newBalance);
            return newBalance;
        } else {
            fruitStorage.save(fruit, fruitDto.getCountFruit());
            return fruitDto.getCountFruit();
        }
    }
}

