package serviceImpl;

import java.util.Map;
import model.FruitTransaction;
import service.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getFruit(),
                storage.getOrDefault(transaction.getFruit(), 0) + transaction.getQuantity());
    }
}
