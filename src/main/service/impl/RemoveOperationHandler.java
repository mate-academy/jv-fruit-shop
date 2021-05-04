package main.service.impl;

import main.Exceptions.IllegalOperationException;
import main.model.dao.FruitDao;
import main.model.dao.FruitDaoImpl;
import main.model.dto.FruitRecordDto;
import main.service.interfaces.OperationHandler;

public class RemoveOperationHandler implements OperationHandler {
    private static final String REMOVE_FAILED_OUT_OF_STOCK = "Can't purchase, not enough %s in stock.";
    private final FruitDao fruitDao;

    public RemoveOperationHandler() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        if (fruitRecordDto.getQuantity() > fruitDao.getCurrentQuantity(fruitRecordDto)) {
            throw new IllegalOperationException(String.format(REMOVE_FAILED_OUT_OF_STOCK, fruitRecordDto.getName()));
        }
        int newQuantity = fruitDao.getCurrentQuantity(fruitRecordDto) - fruitRecordDto.getQuantity();
        fruitDao.update(fruitRecordDto, newQuantity);
        return newQuantity;
    }
}
