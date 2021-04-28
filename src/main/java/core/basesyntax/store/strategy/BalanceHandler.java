package core.basesyntax.store.strategy;

import core.basesyntax.store.FruitService;
import core.basesyntax.store.FruitServiceImpl;

public class BalanceHandler implements TypeHandler {
    private final FruitService fruitService;

    public BalanceHandler() {
        fruitService = new FruitServiceImpl();
    }

    @Override
    public void makeOperation(String fruitName, long quantity, int lineNumber) {
        fruitService.createNewFruit(fruitName, quantity);
    }
}
