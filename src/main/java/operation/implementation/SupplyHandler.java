package operation.implementation;

import model.FruitTransaction;
import operation.OperationHandler;
import service.FruitService;

public class SupplyHandler implements OperationHandler {
    private final FruitService fruitService;

    public SupplyHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitService.add(fruitTransaction.getFruit(),
                fruitService.getQuantity(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
