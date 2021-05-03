package service.impl;

import model.dto.FruitRecordDto;
import service.PurchaseFruitHandler;
import storage.Db;

public class PurchaseFruitHandlerImpl implements PurchaseFruitHandler {
    private static final int ZERO = 0;

    @Override
    public int purchaseFruit(FruitRecordDto fruitRecordDto) {
        checkPurchaseValidation(fruitRecordDto);
        int amountOnBalance = Db.getDataBase().get(fruitRecordDto.getFruit());
        Db.getDataBase().put(fruitRecordDto.getFruit(), amountOnBalance
                - fruitRecordDto.getAmount());
        return Db.getDataBase().get(fruitRecordDto.getFruit());
    }

    void checkPurchaseValidation(FruitRecordDto fruitRecordDto) {
        int amountOnBalance = Db.getDataBase().get(fruitRecordDto.getFruit());
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
