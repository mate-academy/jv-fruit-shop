package core.basesyntax.handlers;

import core.basesyntax.data.DataValidator;
import core.basesyntax.data.impl.FruitShopValidator;
import core.basesyntax.dto.Dto;
import core.basesyntax.storage.FruitDataBase;
import core.basesyntax.strategy.FruitsStrategy;

public class FruitsDecrement implements FruitsStrategy {
    @Override
    public int change(Dto fruitDto, FruitDataBase fruitDataBase) {
        Integer oldFruitAmount = fruitDataBase.getFruitShopData(fruitDto.getFruit());
        DataValidator dataValidator = new FruitShopValidator();
        dataValidator.validateFruitName(oldFruitAmount);
        dataValidator.validateAmount(oldFruitAmount, fruitDto.getAmount());
        int soldAmount = oldFruitAmount - fruitDto.getAmount();
        fruitDataBase.setFruitShopData(fruitDto.getFruit(), soldAmount);
        return soldAmount;
    }
}
