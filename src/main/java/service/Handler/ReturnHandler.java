package service.Handler;

import model.FruitTransaction;
import service.Handler.OperationHandler;

import java.util.Map;

public class ReturnHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction,
                      Map<String, Integer> fruitBalance) {
        fruitBalance.put(fruitTransaction.getFruit(),
                fruitBalance.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
