package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.SupplyFruitHandler;
import core.basesyntax.storage.DataBase;

public class SupplyFruitsImpl implements SupplyFruitHandler {

    @Override
    public int addFruit(FruitRecordDto fruitRecordDto) {
        int amountOnBalance = DataBase.getDataBase().get(fruitRecordDto.getFruit());
        DataBase.getDataBase().put(fruitRecordDto.getFruit(), amountOnBalance
                + fruitRecordDto.getAmount());
        return DataBase.getDataBase().get(fruitRecordDto.getFruit());
    }
}
