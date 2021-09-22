package fruitshop.service.operations;

import fruitshop.fruitstoragedb.FruitStorage;
import fruitshop.model.RecordDto;

public class BalanceOperationHandler implements OperationHandler {
    private static final String DOUBLE_BALANCE_CALCULATION_NOTIFICATION
            = "Balance already has been calculated today, check input data!";

    @Override
    public void applyOperation(RecordDto data) {
        if (FruitStorage.getStorage().containsKey(data.getFruitType())
                && FruitStorage.getStorage().get(data.getFruitType()) != 0) {
            throw new RuntimeException(DOUBLE_BALANCE_CALCULATION_NOTIFICATION);
        }
        FruitStorage.getStorage().put(data.getFruitType(), data.getAmount());
    }
}
