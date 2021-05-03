package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import core.basesyntax.servise.FruitRecordDto;
import core.basesyntax.servise.exception.InvalidValueOfAmountException;

public class StrategySubtraction implements Strategy {
    @Override
    public int changeBalance(FruitRecordDto fruitRecordDto) {
        Fruit newFruit = new Fruit(fruitRecordDto.getFruit());
        Integer currentAmount = Storage.storageOfFruits.get(newFruit);
        if (currentAmount == null) {
            throw new InvalidValueOfAmountException("Amount of fruit \"" + fruitRecordDto.getFruit()
                    + "\" is not exist!  Please check your file and try again.");
        }
        int newAmount = currentAmount - fruitRecordDto.getAmountOfFruit();
        if (newAmount < 0) {
            throw new InvalidValueOfAmountException("Amount can't be less then 0!"
                    + " Please check your file and try again.");
        }
        Storage.storageOfFruits.put(newFruit, newAmount);
        return newAmount;
    }
}
