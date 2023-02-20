package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.function.BinaryOperator;

public class OperatorStrategy {
    public BinaryOperator<Integer> getOperator(FruitTransaction.Operation operation) {
        switch (operation) {
            case BALANCE:
            case RETURN:
            case SUPPLY:
                return Integer::sum;
            default:
                return (a, b) -> a - b;
        }
    }
}
