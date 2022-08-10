package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    private final FruitDao fruitStorage;

    public ReturnHandler(FruitDao fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int remainder = fruitStorage.getQuantity(transaction.getFruitType());
        int newQuantity = remainder + transaction.getQuantity();
        fruitStorage.add(transaction.getFruitType(), newQuantity);
    }
}
