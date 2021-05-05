package core.basesyntax.service.impl;

import core.basesyntax.exceptions.IllegalOperationException;
import core.basesyntax.model.dao.FruitDao;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.interfaces.OperationHandler;

public class RemoveOperationHandler implements OperationHandler {
    private static final String REMOVE_FAILED_OUT_OF_STOCK =
            "Can't purchase, not enough %s in stock.";
    private final FruitDao fruitDao;

    public RemoveOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        if (fruitRecordDto.getQuantity() > fruitDao.getCurrentQuantity(fruitRecordDto)) {
            throw new IllegalOperationException(String.format(REMOVE_FAILED_OUT_OF_STOCK,
                    fruitRecordDto.getName()));
        }
        int newQuantity =
                fruitDao.getCurrentQuantity(fruitRecordDto) - fruitRecordDto.getQuantity();
        fruitDao.update(fruitRecordDto, newQuantity);
        return newQuantity;
    }
}
