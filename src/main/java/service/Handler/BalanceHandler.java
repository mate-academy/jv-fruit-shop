package service.Handler;

import model.FruitTransaction;
import service.Handler.OperationHandler;

import java.util.Map;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction,
                      Map<String, Integer> fruitBalance) {
        fruitBalance.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
