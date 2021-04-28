package core.basesyntax.handlers;

import core.basesyntax.dto.Dto;
import core.basesyntax.storage.FruitDataBase;
import core.basesyntax.strategy.FruitsStrategy;

public class FruitsIncrement implements FruitsStrategy {
    @Override
    public int change(Dto fruitDto, FruitDataBase fruitDataBase) {
        Integer oldFruitAmount = fruitDataBase.getFruitShopData(fruitDto.getFruit());
        int addedAmount = oldFruitAmount + fruitDto.getAmount();
        fruitDataBase.setFruitShopData(fruitDto.getFruit(), addedAmount);
        return addedAmount;
    }
}
