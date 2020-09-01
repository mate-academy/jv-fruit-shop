package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.FruitOperation;
import java.time.LocalDate;

public class BuyFruitOperation implements FruitOperation {
    private StorageService storageService = new StorageService();

    @Override
    public void doOperation(FruitDto fruitDto) {
        String fruitName = fruitDto.getFruitName();
        if (storageService.checkIsFruitPresent(fruitName)) {
            LocalDate dateFromTransaction = fruitDto.getFruitDtoDate();
            Integer amountToSubtract = fruitDto.getAmount();
            storageService.extractFromStorage(amountToSubtract, dateFromTransaction, fruitName);
        } else {
            throw new RuntimeException("We do not have this fruit.");
        }
    }
}
