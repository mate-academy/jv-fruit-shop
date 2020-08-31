package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitStorage;
import core.basesyntax.service.FruitOperation;
import java.time.LocalDate;
import java.util.Map;

public class BuyFruitOperation implements FruitOperation {
    private Map<String, Fruit> storage = FruitStorage.getFruitStorage();
    private StorageService storageService = new StorageService();

    @Override
    public void doOperation(FruitDto fruitDto) {
        String key = fruitDto.getFruitName();
        if (storage.containsKey(key)) {
            LocalDate dateFromTransaction = fruitDto.getFruitDtoDate();
            Integer amountToSubtract = fruitDto.getAmount();
            storageService.extractFromStorage(amountToSubtract, dateFromTransaction, key);
        } else {
            throw new RuntimeException("We do not have this fruit.");
        }
    }
}
