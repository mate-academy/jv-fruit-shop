package core.basesyntax.service.handlers;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;

public class RemoveOperationStrategy implements FruitOperationStrategy {
    private static final int DEFAULT_VALUE = 0;
    private static final String EXCEPTION_MESSAGE = "Amount of fruits you want "
            + "to buy is bigger than we currently have";
    private final FruitDao fruitDao;

    public RemoveOperationStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public int applyAction(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruit().getName());
        int currentQuantity = fruitDao.getQuantity(fruit).orElse(DEFAULT_VALUE);
        int subtractionResult = currentQuantity - fruitRecordDto.getQuantity();
        if (subtractionResult < DEFAULT_VALUE) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        fruitDao.save(fruit, subtractionResult);
        return subtractionResult;
    }
}
