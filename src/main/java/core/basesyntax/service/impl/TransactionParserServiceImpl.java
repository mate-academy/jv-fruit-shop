package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> parse(List<String> dataSheet) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < dataSheet.size(); i++) {
            String[] fields = dataSheet.get(i).split(SEPARATOR);

            FruitTransaction transaction = new FruitTransaction();
            transaction.setFruit(new Fruit(fields[FRUIT_INDEX]));
            transaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));

            String operationValue = fields[OPERATION_INDEX];
            FruitTransaction.Operation operation
                    = Arrays.stream(FruitTransaction.Operation.values())
                    .filter(v -> v.getOperation().equals(operationValue))
                    .findFirst()
                    .get();
            transaction.setOperation(operation);
            transactions.add(transaction);
        }
        return transactions;
    }
}
