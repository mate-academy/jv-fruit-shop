package core.basesyntax.strategy;

import core.basesyntax.service.OperationSelector;
import core.basesyntax.service.impl.OperationSelectorBalance;
import core.basesyntax.service.impl.OperationSelectorPurchase;
import core.basesyntax.service.impl.OperationSelectorReturn;
import core.basesyntax.service.impl.OperationSelectorSupply;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationSelector get(String type) {
        switch (type) {
            case "b":
                return new OperationSelectorBalance();
            case "r":
                return new OperationSelectorReturn();
            case "p":
                return new OperationSelectorPurchase();
            case "s":
                return new OperationSelectorSupply();
            default:
                throw new RuntimeException("Can't work with this operator");
        }
    }
}
