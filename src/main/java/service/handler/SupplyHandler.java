package service.handler;

import java.util.Map;
import model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction,
                      Map<String, Integer> fruitBalance) {
        fruitBalance.put(fruitTransaction.getFruit(),
                fruitBalance.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
