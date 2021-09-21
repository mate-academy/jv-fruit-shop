package fruitshop.service.operations;

import fruitshop.fruitstoragedb.FruitStorage;
import fruitshop.model.Fruit;
import fruitshop.model.OperationsDto;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    private static final String DOUBLE_BALANCE_CALCULATION_NOTIFICATION
            = "Balance already has been calculated today, check input data!";

    @Override
    public void applyOperation(OperationsDto data) {
        Map<Fruit, Integer> fruitStorage = FruitStorage.getStorage();

        if (fruitStorage.containsKey(data.getFruitType())
                && fruitStorage.get(data.getFruitType()) != 0) {
            throw new RuntimeException(DOUBLE_BALANCE_CALCULATION_NOTIFICATION);
        }
        fruitStorage.put(data.getFruitType(), data.getAmount());
    }
}
