package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.ApplyFruitHandler;
import core.basesyntax.service.Validator;
import core.basesyntax.storage.DataBase;
import java.util.Optional;

public class PurchaseFruitHandlerImpl implements ApplyFruitHandler {

    @Override
    public int applyFruit(FruitRecordDto fruitRecordDto) {
        Validator validator = new ValidatorImpl();
        validator.checkPurchaseValidation(fruitRecordDto);
        int amountOnBalance = Optional.ofNullable(DataBase
                .getDataBase().get(fruitRecordDto.getName())).orElse(0);
        DataBase.getDataBase().put(fruitRecordDto.getName(), amountOnBalance
                - fruitRecordDto.getAmount());
        return DataBase.getDataBase().get(fruitRecordDto.getName());
    }
}
