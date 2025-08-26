package strategy.impl;

import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {

    @Override
    public int getOperation(FruitTransaction data, int amount) {
        if (data == null) {
            throw new RuntimeException(
                    "Data cannot be null");
        }
        return data.getQuantity() + amount;
    }
}
