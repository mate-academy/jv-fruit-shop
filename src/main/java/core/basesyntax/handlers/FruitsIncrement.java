package core.basesyntax.handlers;

import core.basesyntax.dto.Dto;
import core.basesyntax.services.FruitsService;
import core.basesyntax.storage.FruitDataBase;

public class FruitsIncrement implements FruitsService {
    @Override
    public int change(Dto fruitDto, FruitDataBase fruitDataBase) {
        Integer oldFruitAmount = fruitDataBase.getFruitShopData(fruitDto.getFruit());
        int addedAmount = oldFruitAmount + fruitDto.getAmount();
        fruitDataBase.setFruitShopData(fruitDto.getFruit(), addedAmount);
        return addedAmount;
    }
}
