package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.storage.DataBase;
import java.util.Optional;

public class Validator {
    private static final int ZERO_AMOUNT = 0;

    public void checkPurchaseValidation(FruitRecordDto fruitRecordDto) {
        int amountOnBalance = Optional.ofNullable(DataBase.getDataBase()
                .get(fruitRecordDto.getName())).orElse(0);
        int amountPurchase = fruitRecordDto.getAmount();
        if (amountOnBalance < amountPurchase) {
            throw new RuntimeException("Not enough "
                    + fruitRecordDto.getName() + "'s in Storage");
        }

        if (amountPurchase < ZERO_AMOUNT) {
            throw new RuntimeException(fruitRecordDto.getAmount()
                    + " - wrong input");
        }
    }
}
