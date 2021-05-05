package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.PurchaseFruitHandler;
import core.basesyntax.storage.DataBase;

public class PurchaseFruitHandlerImpl implements PurchaseFruitHandler {
    private static final int ZERO = 0;

    @Override
    public int purchaseFruit(FruitRecordDto fruitRecordDto) {
        checkPurchaseValidation(fruitRecordDto);
        int amountOnBalance = DataBase.getDataBase().get(fruitRecordDto.getFruit());
        DataBase.getDataBase().put(fruitRecordDto.getFruit(), amountOnBalance
                - fruitRecordDto.getAmount());
        return DataBase.getDataBase().get(fruitRecordDto.getFruit());
    }

    void checkPurchaseValidation(FruitRecordDto fruitRecordDto) {
        int amountOnBalance = DataBase.getDataBase().get(fruitRecordDto.getFruit());
        int amountPurchase = fruitRecordDto.getAmount();
        if (amountOnBalance < amountPurchase) {
            throw new RuntimeException("Not enough "
                    + fruitRecordDto.getFruit().getName() + "'s in Storage");
        }
        if (amountPurchase < ZERO) {
            throw new RuntimeException(fruitRecordDto.getAmount()
                    + " - wrong input");
        }
    }

}
