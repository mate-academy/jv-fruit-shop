package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.function.Predicate;

public interface TypeCalculatorStrategy extends Predicate<FruitTransaction.Operation> {
    void calculate(FruitTransaction transaction);
}
