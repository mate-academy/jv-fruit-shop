package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import core.basesyntax.servise.FruitRecordDto;

public class StrategyAdd implements Strategy {
    @Override
    public int changeBalance(FruitRecordDto fruitRecordDto) {
        Fruit newFruit = fruitRecordDto.getFruit();
        Integer currentAmount = Storage.storageOfFruits.get(newFruit);
        int newAmount = currentAmount != null
                ? currentAmount + fruitRecordDto.getAmountOfFruit()
                : fruitRecordDto.getAmountOfFruit();
        Storage.storageOfFruits.put(newFruit, newAmount);
        return newAmount;
    }
}
