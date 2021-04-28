package core.basesyntax.handlers;

import core.basesyntax.data.DataValidator;
import core.basesyntax.data.impl.FruitShopValidator;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.storage.FruitDataBase;
import core.basesyntax.strategy.FruitsStrategy;
import java.util.Optional;

public class FruitsIncrement implements FruitsStrategy {
    @Override
    public int change(TransactionDto fruitDto) {
        Integer oldFruitAmount = Optional.ofNullable(FruitDataBase.getFruitData()
                .get(fruitDto.getFruit())).orElse(0);
        DataValidator dataValidator = new FruitShopValidator();
        dataValidator.validateAmountPositive(fruitDto.getAmount());
        int addedAmount = oldFruitAmount + fruitDto.getAmount();
        FruitDataBase.getFruitData().put(fruitDto.getFruit(), addedAmount);
        return addedAmount;
    }
}
