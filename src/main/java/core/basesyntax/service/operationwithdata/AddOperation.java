package core.basesyntax.service.operationwithdata;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.fruitstorage.FruitStorage;
import java.util.Optional;

public class AddOperation implements FruitOperationService {
    @Override
    public int apply(FruitDto fruitDto) {
        String fruitName = fruitDto.getFruitName();
        Optional<Integer> currentQuantityFruit =
                Optional.ofNullable(FruitStorage.fruitStorage.get(fruitName));
        if (currentQuantityFruit.isPresent()) {
            int newBalance = currentQuantityFruit.get() + fruitDto.getCountFruit();
            FruitStorage.fruitStorage.put(fruitName, newBalance);
            return newBalance;
        } else {
            FruitStorage.fruitStorage.put(fruitName, fruitDto.getCountFruit());
            return fruitDto.getCountFruit();
        }
    }
}

