package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.ReturnFruitHandler;
import core.basesyntax.storage.DataBase;

public class ReturnFruitHandlerImpl implements ReturnFruitHandler {

    @Override
    public int returnFruit(FruitRecordDto fruitRecordDto) {
        int amountOnBalance = DataBase.getDataBase().get(fruitRecordDto.getFruit());
        DataBase.getDataBase().put(fruitRecordDto.getFruit(), amountOnBalance
                + fruitRecordDto.getAmount());
        return DataBase.getDataBase().get(fruitRecordDto.getFruit());
    }
}
