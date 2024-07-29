package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        removeSpaces(inputReport);
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < inputReport.size(); i++) {
            String[] parts = inputReport.get(i).split(",");
            if (parts.length != 3) {
                continue;
            }
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(parts[0].trim());
            String fruit = parts[1].trim();
            int quantity = Integer.parseInt(parts[2].trim());
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }

    private static List<String> removeSpaces(List<String> inputReport) {
        for (int i = 0; i < inputReport.size(); i++) {
            inputReport.set(i, inputReport.get(i).replace(" ",""));
        }
        return inputReport;
    }
}
