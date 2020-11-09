package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.FruitDateAmountPair;
import core.basesyntax.service.FruitOperation;

public class ReturnFruitOperation implements FruitOperation {
    private StorageService storageService = new StorageService();

    @Override
    public void doOperation(FruitDto fruitDto) {
        String fruitName = fruitDto.getFruitName();
        Integer amountToReturn = fruitDto.getAmount();
        FruitDateAmountPair fruit;
        if (storageService.checkIsFruitPresent(fruitName)) {
            fruit = storageService.getFruitFromStorage(fruitDto, fruitName, amountToReturn);
            if (fruit == null) {
                return;
            }
        } else {
            throw new RuntimeException("You can not return this fruit");
        }
    }
}
