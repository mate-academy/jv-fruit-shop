package service.impl;

import model.dto.FruitRecordDto;
import service.SetBalanceHandler;
import storage.Db;

public class SetBalanceHandlerImpl implements SetBalanceHandler {

    @Override
    public int setBalance(FruitRecordDto fruitRecordDto) {
        Db.getDataBase().put(fruitRecordDto.getFruit(), fruitRecordDto.getAmount());
        return Db.getDataBase().get(fruitRecordDto.getFruit());
    }
}
