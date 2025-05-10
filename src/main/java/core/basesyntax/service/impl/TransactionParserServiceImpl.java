package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.model.Transaction.Operation;
import core.basesyntax.service.TransactionParserService;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final String DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> parse(List<String> transactions) {
        List<Transaction> list = new ArrayList<>();

        for (String transaction : transactions) {
            String[] values = transaction.split(DELIMITER);
            Operation operation = parseOperation(values[OPERATION_INDEX]);
            int quantity = Integer.parseInt(values[QUANTITY_INDEX]);

            list.add(new Transaction(operation, values[FRUIT_INDEX], quantity));
        }

        return list;
    }

    private Operation parseOperation(String code) {
        for (Operation value: Operation.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }

        throw new RuntimeException("Error parsing operation code '" + code + "'.");
    }
}
