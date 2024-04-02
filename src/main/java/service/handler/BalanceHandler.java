package service.handler;

import java.util.Map;
import model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction,
                      Map<String, Integer> fruitBalance) {
        fruitBalance.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
