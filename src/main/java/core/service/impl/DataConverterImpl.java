package core.service.impl;

import core.service.DataConverter;
import core.strategy.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String CSV_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : inputReport) {
            // Розбиваємо рядок на частини за комою
            String[] values = line.split(CSV_SEPARATOR);

            // Створюємо об'єкт транзакції
            FruitTransaction transaction = new FruitTransaction();

            // Встановлюємо значення (логіка залежить від твоєї моделі FruitTransaction)
            transaction.setOperation(FruitTransaction.Operation.fromCode(values[OPERATION_INDEX]));
            transaction.setFruit(values[FRUIT_NAME_INDEX]);
            transaction.setQuantity(Integer.parseInt(values[QUANTITY_INDEX]));

            transactions.add(transaction);
        }
        return transactions;
    }
}
