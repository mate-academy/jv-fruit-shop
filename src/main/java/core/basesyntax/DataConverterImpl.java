package core.basesyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            if (line.startsWith("type")) {
                continue;
            }
            String[] parts = line.split(",");
            FruitTransaction.Operation operation = getOperationByCode(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }

    private FruitTransaction.Operation getOperationByCode(String code) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(op -> op.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown operation: " + code));
    }
}
