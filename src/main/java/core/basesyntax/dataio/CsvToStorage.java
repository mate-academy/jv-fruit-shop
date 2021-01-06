package core.basesyntax.dataio;

import core.basesyntax.model.Fruit;
import core.basesyntax.operation.OperationMap;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.Operations;
import java.util.List;
import java.util.Objects;

public class CsvToStorage {
    private static final String SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final List<String> data;
    private final OperationStrategy operationStrategy =
            new OperationStrategyImpl(new OperationMap().getOperationMap());

    public CsvToStorage(List<String> data) {
        this.data = data;
        toStorage();
    }

    public void toStorage() {
        for (String line: data) {
            String[] splited = line.split(SPLITTER);
            if (Integer.parseInt(splited[QUANTITY_INDEX]) < 0) {
                throw new RuntimeException("negative value. You should chek your db");
            }
            operationStrategy.get(chek(splited[OPERATION_INDEX]))
                    .doOperation(new Fruit(splited[FRUIT_INDEX]),
                            Integer.parseInt(splited[QUANTITY_INDEX]));
        }
    }

    private Operations chek(String operation) {
        for (Operations current : Operations.values()) {
            if (Objects.equals(current.getOperation(), operation.toLowerCase().trim())) {
                return current;
            }
        }
        throw new RuntimeException("Wrong operation " + operation);
    }
}
