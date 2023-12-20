package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class CsvParserService implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int ARRAY_LENGTH_REQUIRED = 3;

    @Override
    public List<FruitTransaction> parseCsv(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        if (lines.size() > 0) {
            if (lines.get(0).toLowerCase().contains("type,fruit,quantity")) {
                lines = lines.subList(1, lines.size());
            }
        }

        for (String line : lines) {
            FruitTransaction transaction = parseCsvLine(line);
            fruitTransactions.add(transaction);
        }

        return fruitTransactions;
    }

    private FruitTransaction parseCsvLine(String line) {
        String[] parsedArray = line.split(",");

        if (parsedArray.length == ARRAY_LENGTH_REQUIRED
                && !parsedArray[OPERATION_INDEX].equalsIgnoreCase("type")) {
            String operationCode = parsedArray[OPERATION_INDEX].trim();
            String fruit = parsedArray[FRUIT_INDEX].trim();

            try {
                int quantity = Integer.parseInt(parsedArray[QUANTITY_INDEX].trim());

                FruitTransaction.Operation operation
                        = FruitTransaction.Operation.getByCode(operationCode);

                FruitTransaction transaction = new FruitTransaction();
                transaction.setOperation(operation);
                transaction.setFruit(fruit);
                transaction.setQuantity(quantity);

                return transaction;
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity format in line: " + line);
            }
        } else {
            throw new RuntimeException("Invalid line format: " + line);
        }
    }
}
