package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitStorage;
import core.basesyntax.service.FruitOperation;
import java.util.Map;

public class SupplyFruitOperation implements FruitOperation {
    private Map<String, Fruit> storage = FruitStorage.getFruitStorage();
    private StorageService storageService = new StorageService();

    @Override
    public void doOperation(FruitDto fruitDto) {
        String fruitName = fruitDto.getFruitName();
        Integer amountToSupply = fruitDto.getAmount();
        Fruit fruit;
        if (storage.containsKey(fruitName)) {
            fruit = storageService.getFruitFromStorage(fruitDto, fruitName, amountToSupply);
            if (fruit == null) {
                return;
            }
        } else {
            fruit = new Fruit(fruitDto.getFruitDtoDate(),
                    amountToSupply);
        }
        storage.put(fruitName, fruit);
    }
}
