package core.strategy.handlers;

import core.service.FruitService;

public class BalanceHandler implements OperationHandler {
    private FruitService fruitService;

    public BalanceHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        fruitService.update(fruitName,quantity);
    }
}
