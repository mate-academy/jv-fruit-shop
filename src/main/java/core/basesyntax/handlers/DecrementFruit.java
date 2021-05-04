package core.basesyntax.handlers;

import core.basesyntax.db.FruitDataBase;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.services.DataValidator;
import core.basesyntax.services.impl.DataValidatorImpl;
import core.basesyntax.strategy.FruitStrategy;
import java.util.Optional;

public class DecrementFruit implements FruitStrategy {
    @Override
    public void change(TransactionDto fruitDto) {
        Integer oldAmount = Optional.ofNullable(FruitDataBase.getFruitMap()
                .get(fruitDto.getFruit())).orElse(0);
        DataValidator dataValidator = new DataValidatorImpl();
        dataValidator.validateAmount(oldAmount, fruitDto.getAmount());
        int soldAmount = oldAmount - fruitDto.getAmount();
        FruitDataBase.getFruitMap().put(fruitDto.getFruit(), soldAmount);
    }
}
