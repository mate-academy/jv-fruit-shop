package core.basesyntax.service.impl;

import core.basesyntax.model.dao.FruitDao;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.interfaces.OperationHandler;

public class AddOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public AddOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        int currentQuantity = fruitDao.getCurrentQuantity(fruitRecordDto);
        int newQuantity = currentQuantity + fruitRecordDto.getQuantity();
        fruitDao.update(fruitRecordDto, newQuantity);
        return newQuantity;
    }
}
