package core.basesyntax.strategy;

import core.basesyntax.dto.TransactionDto;

public interface FruitStrategy {
    void change(TransactionDto fruitDto);
}
