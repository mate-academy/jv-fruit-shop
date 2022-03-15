package core.basesyntax.exceptions;

import core.basesyntax.model.Fruit;

public class OverPurchaseException extends RuntimeException {
    public OverPurchaseException(Fruit fruit) {
        super("You can't overbuy " + fruit.getName());
    }
}
