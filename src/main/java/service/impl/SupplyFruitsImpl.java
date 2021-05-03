package service.impl;

import model.dto.FruitRecordDto;
import service.SupplyFruitHandler;
import storage.Db;

public class SupplyFruitsImpl implements SupplyFruitHandler {

    @Override
    public int addFruit(FruitRecordDto fruitRecordDto) {
        int amountOnBalance = Db.getDataBase().get(fruitRecordDto.getFruit());
        Db.getDataBase().put(fruitRecordDto.getFruit(), amountOnBalance
                + fruitRecordDto.getAmount());
        return Db.getDataBase().get(fruitRecordDto.getFruit());
    }
}
