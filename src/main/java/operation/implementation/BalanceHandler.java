package operation.implementation;

import model.FruitTransaction;
import operation.OperationHandler;
import service.FruitService;

public class BalanceHandler implements OperationHandler {
    private final FruitService fruitService;

    public BalanceHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitService.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
