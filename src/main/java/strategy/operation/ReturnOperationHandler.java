package strategy.operation;

import db.Storage;
import java.util.Optional;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private static final int INITIAL_BALANCE = 0;

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldSum = Optional.ofNullable(Storage.fruits.get(fruitTransaction.getFruit()))
                .orElse(INITIAL_BALANCE + fruitTransaction.getQuantity());
        Storage.fruits.put(fruitTransaction.getFruit(), oldSum + fruitTransaction.getQuantity());
    }
}
