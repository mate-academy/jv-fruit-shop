package core.basesyntax.parser;

import core.basesyntax.transaction.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

//TODO: Пропускати заголовок CSV (type,fruit,quantity) або перевіряти split.length.
//TODO: Виконувати trim() для полів і валідацію quantity (число >= 0).
//TODO: Повернути List<FruitTransaction> замість List<?> в сигнатурі й реалізації.
//TODO: Обробляти NumberFormatException з інформативним повідомленням (рядок/індекс).
public class DataConverterImpl implements DataConverter {

    private final FruitTransactionValidator validator =
            new FruitTransactionValidator();

    @Override
    public List<FruitTransaction> convertToTransaction(Iterable<String> strings) {

        List<FruitTransaction> transactions = new ArrayList<>();
        int rowIndex = 0;

        for (String line : strings) {
            rowIndex++;

            // пропуск заголовка
            if (rowIndex == 1 && line.startsWith("type")) {
                continue;
            }

            ValidationResult result = validator.validate(line, rowIndex);

            if (!result.isValid()) {
                System.err.println(result.getMessage()); // или logger
                continue; // пропускаем строку
            }

            String[] split = line.split(",");

            String type = split[0].trim();
            String fruit = split[1].trim();
            int quantity = Integer.parseInt(split[2].trim());

            transactions.add(
                    new FruitTransaction(type, fruit, quantity)
            );
        }

        return transactions;
    }
}
