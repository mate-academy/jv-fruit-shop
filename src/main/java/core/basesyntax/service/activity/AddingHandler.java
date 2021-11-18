package core.basesyntax.service.activity;

import core.basesyntax.service.FruitService;

public class AddingHandler implements ActivityHandler {
    private final FruitService fruitStorageService;

    public AddingHandler(FruitService fruitStorageService) {
        this.fruitStorageService = fruitStorageService;
    }

    @Override
    public void apply(String fruitName, int value) {
        for (int i = 0; i < value; i++) {
            fruitStorageService.createFruit(fruitName);
        }
    }
}
