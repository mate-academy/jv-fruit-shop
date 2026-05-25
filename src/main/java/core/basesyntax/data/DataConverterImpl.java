package core.basesyntax.data;

import core.basesyntax.transactions.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < inputReport.size(); i++) {
            String line = inputReport.get(i);
            String[] parts = line.split(",");
            if (parts.length < 3) {
                throw new RuntimeException("Invalid line format: " + line);
            }

            String operationCode = parts[0];
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setFruit(fruit);
            fruitTransaction.setQuantity(quantity);
            FruitTransaction.Operation operation = null;

            for (FruitTransaction.Operation op : FruitTransaction.Operation.values()) {
                if (op.getCode().equals(operationCode)) {
                    operation = op;
                    break;
                }
            }

            fruitTransaction.setOperation(operation);
            transactions.add(fruitTransaction);
        }

        return transactions;
    }
}
