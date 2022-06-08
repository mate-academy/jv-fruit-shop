package core.strategy.handlers;

import core.service.FruitService;

public class PurchaseHandler implements OperationHandler {
    private FruitService fruitService;

    public PurchaseHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        int fruitsQuantityInStorage = fruitService.get(fruitName);
        fruitsQuantityInStorage -= quantity;
        fruitService.update(fruitName,fruitsQuantityInStorage);
    }
}
