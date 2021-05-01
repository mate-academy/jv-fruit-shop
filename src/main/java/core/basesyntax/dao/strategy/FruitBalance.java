package core.basesyntax.dao.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;

public class FruitBalance implements FruitOperations {
    @Override
    public void doOperationWithFruit(FruitDto fruitDto) {
        Storage.getFruits().put(fruitDto.getFruitName(), fruitDto.getQuantity());
    }
}
