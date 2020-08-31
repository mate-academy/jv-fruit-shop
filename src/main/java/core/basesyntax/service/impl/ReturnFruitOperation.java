package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitStorage;
import core.basesyntax.service.FruitOperation;
import java.util.Map;

public class ReturnFruitOperation implements FruitOperation {
    private Map<String, Fruit> storage = FruitStorage.getFruitStorage();
    private StorageService storageService = new StorageService();

    @Override
    public void doOperation(FruitDto fruitDto) {
        String fruitName = fruitDto.getFruitName();
        Integer amountToReturn = fruitDto.getAmount();
        Fruit fruit;
        if (storage.containsKey(fruitName)) {
            fruit = storageService.getFruitFromStorage(fruitDto, fruitName, amountToReturn);
            if (fruit == null) {
                return;
            }
        } else {
            throw new RuntimeException("You can not return this fruit");
        }
    }
}
