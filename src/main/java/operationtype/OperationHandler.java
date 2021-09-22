package operationtype;

import model.FruitRecord;

public interface OperationHandler {
    void apply(FruitRecord fruitRecord);
}
