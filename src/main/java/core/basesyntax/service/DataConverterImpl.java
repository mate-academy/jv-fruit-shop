package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convert(List<String> transactions) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        for (String line : transactions) {
            if (line.startsWith("type")) {
                continue;
            }

            String[] splitedLine = line.split(",");

            if (splitedLine.length != 3) {
                continue;
            }

            String operationCode = splitedLine[OPERATION_INDEX].trim();
            FruitTransaction.Operation operation;
            operation = FruitTransaction.getOperationByCode(operationCode);
            String fruitName = splitedLine[FRUIT_NAME_INDEX].trim();
            int fruitQuantity;

            try {
                fruitQuantity = Integer.parseInt(splitedLine[QUANTITY_INDEX].trim());
            } catch (NumberFormatException e) {
                throw new RuntimeException("The number is incorrect! "
                        + splitedLine[QUANTITY_INDEX]);
            }

            fruitTransactionsList.add(new FruitTransaction(operation, fruitName, fruitQuantity));
        }
        return fruitTransactionsList;
    }
}
