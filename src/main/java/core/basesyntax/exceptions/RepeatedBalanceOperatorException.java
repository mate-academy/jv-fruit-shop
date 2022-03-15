package core.basesyntax.exceptions;

import core.basesyntax.model.Fruit;

public class RepeatedBalanceOperatorException extends RuntimeException {
    public RepeatedBalanceOperatorException(Fruit fruit) {
        super("Storage has already set this fruit: " + fruit.getName());
    }
}
