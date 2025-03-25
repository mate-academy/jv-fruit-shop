package core.basesyntax.dataconverter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        data.stream()
                .skip(1)
                .forEach(line -> {
                    try {
                        String[] fields = line.split(SPLITTER);

                        FruitTransaction.Operation operation = FruitTransaction
                                .Operation.fromCode(fields[0].trim());
                        String fruit = fields[1].trim();
                        int quantity = Integer.parseInt(fields[2].trim());

                        transactions.add(new FruitTransaction(operation, fruit, quantity));
                    } catch (Exception e) {
                        System.err.println("Term processing error: " + line);
                    }
                });

        return transactions;
    }
}
