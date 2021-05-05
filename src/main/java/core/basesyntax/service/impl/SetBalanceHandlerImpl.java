package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.ApplyFruitHandler;
import core.basesyntax.storage.DataBase;

public class SetBalanceHandlerImpl implements ApplyFruitHandler {

    @Override
    public int applyFruit(FruitRecordDto fruitRecordDto) {
        DataBase.getDataBase().put(fruitRecordDto.getName(), fruitRecordDto.getAmount());
        return DataBase.getDataBase().get(fruitRecordDto.getName());
    }
}
