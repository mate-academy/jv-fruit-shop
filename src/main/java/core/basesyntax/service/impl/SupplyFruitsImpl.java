package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.ApplyFruitHandler;
import core.basesyntax.storage.DataBase;

public class SupplyFruitsImpl implements ApplyFruitHandler {

    @Override
    public int applyFruit(FruitRecordDto fruitRecordDto) {
        int amountOnBalance = DataBase.getDataBase().get(fruitRecordDto.getName());
        DataBase.getDataBase().put(fruitRecordDto.getName(), amountOnBalance
                + fruitRecordDto.getAmount());
        return DataBase.getDataBase().get(fruitRecordDto.getName());
    }
}
