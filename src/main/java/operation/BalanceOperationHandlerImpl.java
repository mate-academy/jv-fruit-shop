package operation;

import model.FruitTransaction;
import model.Operation;

import java.util.Map;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private final Map<String, Integer> fruitQuantity;

    public BalanceOperationHandlerImpl(Map<String, Integer> fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    @Override
    public void perform(FruitTransaction fruitTransaction) {
        fruitQuantity.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
