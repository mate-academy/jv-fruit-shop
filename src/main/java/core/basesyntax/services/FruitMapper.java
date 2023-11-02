package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class FruitMapper {
    private static final String COMMA = ",";

    public List<FruitTransaction> mapData(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : data) {
            String[] splitLine = line.split(COMMA);
            String operationCode = splitLine[0];
            String fruit = splitLine[1];
            int quantity = Integer.parseInt(splitLine[2]);
            Operation operation = Operation.getOperationByCode(operationCode);
            fruitTransactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return fruitTransactions;
    }
}
