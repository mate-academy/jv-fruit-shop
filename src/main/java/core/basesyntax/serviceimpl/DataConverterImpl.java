package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < inputReport.size(); i++) {
            String[] parts = inputReport.get(i).split(SEPARATOR);

            if (parts.length != 3) {
                throw new RuntimeException("Invalid string format: " + inputReport.get(i));
            }

            String operationCode = parts[0];
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            Operation operation = Operation.fromCode(operationCode);
            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }

        return transactions;
    }
}
