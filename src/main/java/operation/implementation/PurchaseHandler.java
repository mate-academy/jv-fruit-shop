package operation.implementation;

import model.FruitTransaction;
import operation.OperationHandler;
import service.FruitService;

public class PurchaseHandler implements OperationHandler {
    private final FruitService fruitService;

    public PurchaseHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitService.add(fruitTransaction.getFruit(),
                fruitService.getQuantity(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity());
    }
}
