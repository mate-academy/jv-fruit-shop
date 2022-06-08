package core.strategy.handlers;

import core.service.FruitService;

public class ReturnHandler implements OperationHandler {
    private FruitService fruitService;

    public ReturnHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        int fruitsQuantityInStorage = fruitService.get(fruitName);
        fruitsQuantityInStorage += quantity;
        fruitService.update(fruitName,fruitsQuantityInStorage);
    }
}
