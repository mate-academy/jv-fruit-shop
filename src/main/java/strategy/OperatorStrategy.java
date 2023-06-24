package strategy;

import model.FruitTransaction;

public interface OperatorStrategy {
    OperationHandler getHandler(FruitTransaction transaction);
}
