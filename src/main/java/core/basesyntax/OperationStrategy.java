package core.basesyntax;

import java.util.List;

public class OperationStrategy {
    public void fulfillAllOrders(List<List<String>> data, Storage storage) {
        DataParser dataParser = new DataParser();
        OperationStorage operationStorage = new OperationStorage();
        for (List<String> row : data) {
            operationStorage.getOperationMap()
                    .get(row.get(0)).apply(dataParser.mapToFruit(row), storage);
        }
    }
}
