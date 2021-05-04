package main.service.impl;

import main.model.dao.FruitDao;
import main.model.dao.FruitDaoImpl;
import main.model.dto.FruitRecordDto;
import main.service.interfaces.OperationHandler;

public class AddOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public AddOperationHandler() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        int currentQuantity = fruitDao.getCurrentQuantity(fruitRecordDto);
        int newQuantity = currentQuantity + fruitRecordDto.getQuantity();
        fruitDao.update(fruitRecordDto, newQuantity);
        return newQuantity;
    }
}
