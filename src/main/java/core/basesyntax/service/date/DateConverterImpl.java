package core.basesyntax.service.date;

import core.basesyntax.service.FruitTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DateConverterImpl implements DateConverter{
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> rawData) {
        List<FruitTransaction> transactions = new ArrayList<>();

        if (rawData == null || rawData.isEmpty()) {
            return transactions;
        }

        StringBuilder content = new StringBuilder();
        for (String line: rawData) {

            if (line.startsWith("type,fruit,quantity")) {  // skip the first line
                continue;
            }

            String[] parts = line.split(",");

            if (parts.length != 3) {  // skip a line that has not 3 words
                continue;
            }

            String type = parts[0].trim().toLowerCase();
            String fruit = parts[1].trim().toLowerCase();
            String amountStr = parts[2].trim();

            FruitTransaction.Operation operation = FruitTransaction.Operation.operationFromCode(type);

            if (operation == null) {  // skip the line with invalid operation code
                continue;
            }

            if (fruit.isEmpty()) {  // skip the line with empty fruit's name
                continue;
            }

            int amount;
            try {
                amount = Integer.parseInt(amountStr);
                if (amount < 0) {
                    continue;
                }
            } catch (NumberFormatException e) {
                continue;
            }

            FruitTransaction transaction = new FruitTransaction();
            transaction.setAmount(amount);
            transaction.setFruit(fruit);
            transaction.setOperation(operation);
        }

        return transactions;

    }
}
