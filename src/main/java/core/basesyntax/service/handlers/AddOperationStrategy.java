package core.basesyntax.service.handlers;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;

public class AddOperationStrategy implements FruitOperationStrategy {
    private static final int DEFAULT_VALUE = 0;
    private final FruitDao fruitDao;

    public AddOperationStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public int applyAction(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruit().getName());

        int currentQuantity = fruitDao.getQuantity(fruit).orElse(DEFAULT_VALUE);
        int newQuantity = currentQuantity + fruitRecordDto.getQuantity();
        fruitDao.save(fruit, newQuantity);
        return newQuantity;
    }
}
