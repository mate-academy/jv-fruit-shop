package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public class ReturnService implements OperationHandler {
    /**
     * return some amount of fruis back to storage
     */
    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        SupplyService supplyService = new SupplyService();
        supplyService.doOperation(fruitTransaction);
    }
}
