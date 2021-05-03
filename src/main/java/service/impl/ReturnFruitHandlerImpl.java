package service.impl;

import model.dto.FruitRecordDto;
import service.ReturnFruitHandler;
import storage.Db;

public class ReturnFruitHandlerImpl implements ReturnFruitHandler {

    @Override
    public int returnFruit(FruitRecordDto fruitRecordDto) {
        int amountOnBalance = Db.getDataBase().get(fruitRecordDto.getFruit());
        Db.getDataBase().put(fruitRecordDto.getFruit(), amountOnBalance
                + fruitRecordDto.getAmount());
        return Db.getDataBase().get(fruitRecordDto.getFruit());
    }
}
