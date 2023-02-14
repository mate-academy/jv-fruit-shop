package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;

public class BalanceHandler implements OperationHandler {
    private final FruitService fruitService;

    public BalanceHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitService.update(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
