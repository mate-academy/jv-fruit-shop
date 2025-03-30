package core.basesyntax.dataconverter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> result = new ArrayList<>();

        for (String report : inputReport) {
            String[] reportAsBits = report.split(",");

            FruitTransaction.Operation operation = null;
            switch (reportAsBits[0].trim().toLowerCase()) {
                case "b" -> operation = FruitTransaction.Operation.BALANCE;
                case "s" -> operation = FruitTransaction.Operation.SUPPLY;
                case "p" -> operation = FruitTransaction.Operation.PURCHASE;
                default -> operation = FruitTransaction.Operation.RETURN;
            }

            String fruit = reportAsBits[1];
            int quantity = Integer.parseInt(reportAsBits[2]);
            result.add(new FruitTransaction(operation, fruit, quantity));
        }
        return result;
    }
}
