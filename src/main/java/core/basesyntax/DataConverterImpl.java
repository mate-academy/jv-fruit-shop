package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputData) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : inputData) {
            if (line.startsWith("type")) {
                continue;
            }
            String[] parts = line.split(",");
            String operationCode = parts[0];
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            FruitTransaction.Operation operation = getOperationFromCode(operationCode);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }

    private FruitTransaction.Operation getOperationFromCode(String code) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + code);
    }
}
