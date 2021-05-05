package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.SetBalanceHandler;
import core.basesyntax.storage.DataBase;

public class SetBalanceHandlerImpl implements SetBalanceHandler {

    @Override
    public int setBalance(FruitRecordDto fruitRecordDto) {
        DataBase.getDataBase().put(fruitRecordDto.getFruit(), fruitRecordDto.getAmount());
        return DataBase.getDataBase().get(fruitRecordDto.getFruit());
    }
}
