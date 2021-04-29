package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitDataDto;
import core.basesyntax.service.OperationService;

public class OperationServiceSupplyImpl implements OperationService {
    @Override
    public void doOperation(FruitDataDto fruitRecordDto) {
        FruitDao fruitDao = new FruitDaoImpl();
        fruitDao.add(new Fruit(fruitRecordDto.getFruitName()),
                fruitDao.get(new Fruit(fruitRecordDto.getFruitName()))
                        + fruitRecordDto.getFruitQuantity());
    }
}
