package core.basesyntax.service.activity;

import core.basesyntax.service.FruitService;

public class IncreasingActivityOperation implements ActivityOperation {
    private final FruitService fruitStorageService;

    public IncreasingActivityOperation(FruitService fruitStorageService) {
        this.fruitStorageService = fruitStorageService;
    }

    @Override
    public void apply(String fruitName, int value) {
        for (int i = 0; i < value; i++) {
            fruitStorageService.createFruitBox(fruitName);
        }
    }
}
