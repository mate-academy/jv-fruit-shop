package core.basesyntax;

import java.util.List;

public class OperationStrategy {
    public void fulfillAllOrders(List<String> row, Storage storage, FruitPackage fruitPackage) {
        OperationStorage operationStorage = new OperationStorage();
        operationStorage.getOperationMap().get(row.get(0)).apply(fruitPackage, storage);
    }
}
