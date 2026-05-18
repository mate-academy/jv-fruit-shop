package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            String[] parts = line.split(",");
            FruitTransaction transaction = new FruitTransaction();
            for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
                if (operation.getAction().equals(parts[0])) {
                    transaction.setOperation(operation);
                    break;
                }
            }
            transaction.setFruit(parts[1]);
            transaction.setQuantity(Integer.parseInt(parts[2]));
            transactions.add(transaction);
        }
        return transactions;
    }
}
