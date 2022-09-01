package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_COLUMN = 0;
    private static final int FRUIT_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;
    private static final String REGEX = ",";

    public List<Transaction> parse(List<String> data) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] column = data.get(i).split(REGEX);
            Transaction transaction = new Transaction();
            transaction.setFruit(new Fruit(column[FRUIT_COLUMN]));
            transaction.setSum(Integer.parseInt(column[QUANTITY_COLUMN]));
            String operationValue = column[OPERATION_COLUMN];

            Transaction.Operation operation;
            operation = Arrays.stream(Transaction.Operation.values())
                    .filter(o -> o.getOperation().equals(operationValue))
                    .findFirst()
                    .get();
            transaction.setOperation(operation);
            transactions.add(transaction);
        }
        return transactions;
    }
}

