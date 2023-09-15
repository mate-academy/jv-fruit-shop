package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.TransactionParserService;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String[] fields = data.get(i).split(SEPARATOR);

            FruitTransaction transaction = new FruitTransaction();
            transaction.setFruit(new Fruit(fields[FRUIT_INDEX]));
            transaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));

            String operationValue = fields[OPERATION_INDEX];

            Operation operation = Operation.fromOperationValue(operationValue);
            transaction.setOperation(operation);
            transactions.add(transaction);
        }
        return transactions;
    }
}
