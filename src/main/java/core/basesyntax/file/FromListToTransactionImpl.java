package core.basesyntax.file;

import core.basesyntax.transactions.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FromListToTransactionImpl implements FromListToTransaction {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int EXPECTED_PARTS = 3;

    @Override
    public List<FruitTransaction> finalProcess(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");

            if (parts.length != EXPECTED_PARTS) {
                throw new RuntimeException("Invalid line: " + lines.get(i));
            }

            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(findOperation(parts[OPERATION_INDEX].trim()));
            transaction.setFruit(parts[FRUIT_INDEX].trim());
            transaction.setQuantity(
                    Integer.parseInt(parts[QUANTITY_INDEX].trim())
            );

            transactions.add(transaction);
        }

        return transactions;

    }

    private FruitTransaction.Operation findOperation(String code) {
        for (FruitTransaction.Operation operation
                : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }

        throw new RuntimeException("Unknown operation code: " + code);
    }
}
