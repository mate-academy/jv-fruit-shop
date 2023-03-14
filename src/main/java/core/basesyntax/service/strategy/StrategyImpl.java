package core.basesyntax.service.strategy;

import core.basesyntax.service.db.Options;
import core.basesyntax.service.model.FruitTransaction;
import core.basesyntax.service.operation.FruitService;

public class StrategyImpl implements Strategy {
    private final Options options = new Options();

    @Override
    public FruitService choosePattern(FruitTransaction fruitTransaction) {
        options.initialHandler();
        return options.getHandlerMap().get(fruitTransaction.getOperation().trim());
    }
}
