package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < inputReport.size(); i++) {
            String[] parts = inputReport.get(i).split(",");
            if (parts.length == 3) {
                String operationCode = parts[0].trim();
                String fruit = parts[1].trim();
                int quantity = Integer.parseInt(parts[2].trim());

                Operation operation = Operation.fromCode(operationCode);

                FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                transactions.add(transaction);
            } else {
                System.out.println("Невірний формат рядка: " + inputReport.get(i));
            }
        }

        return transactions;
    }
}
