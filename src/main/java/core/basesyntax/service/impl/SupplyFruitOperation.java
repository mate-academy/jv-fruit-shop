package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.FruitDateAmountPair;
import core.basesyntax.service.FruitOperation;

public class SupplyFruitOperation implements FruitOperation {
    private StorageService storageService = new StorageService();

    @Override
    public void doOperation(FruitDto fruitDto) {
        String fruitName = fruitDto.getFruitName();
        Integer amountToSupply = fruitDto.getAmount();
        FruitDateAmountPair fruit;
        if (storageService.checkIsFruitPresent(fruitName)) {
            fruit = storageService.getFruitFromStorage(fruitDto, fruitName, amountToSupply);
            if (fruit == null) {
                return;
            }
        } else {
            fruit = new FruitDateAmountPair(fruitDto.getFruitDtoDate(),
                    amountToSupply);
        }
        storageService.addFruitToStorage(fruitName, fruit);
    }
}
