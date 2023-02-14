package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;

public class PurchaseHandler implements OperationHandler {
    private final FruitService fruitService;

    public PurchaseHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitService.update(fruitTransaction.getFruit(),
                fruitService.getQuantity(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity());
    }
}
