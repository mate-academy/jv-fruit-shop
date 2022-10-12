package core.basesyntax.service.impl;

import core.basesyntax.exeption.OperationNotFoundExeption;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.DataParserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DataParserServiceImpl implements DataParserService {
    private static final int OPERATION_TYPE_COLUMN_INDEX = 0;
    private static final int FRUIT_NAME_COLUMN_INDEX = 1;
    private static final int QUANTITY_COLUMN_INDEX = 2;
    private static final String CSV_COLUMNS_SPLITTER = ",";

    public List<Transaction> parse(List<String> data) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] column = data.get(i).split(CSV_COLUMNS_SPLITTER);
            Transaction transaction = new Transaction();
            String operationFromFile = column[OPERATION_TYPE_COLUMN_INDEX];
            transaction.setFruit(new Fruit(column[FRUIT_NAME_COLUMN_INDEX]));
            transaction.setSum(Integer.parseInt(column[QUANTITY_COLUMN_INDEX]));
            Optional<Transaction.Operation> optionalOperation =
                    Arrays.stream(Transaction.Operation.values())
                    .filter(o -> o.getOperation().equals(operationFromFile))
                    .findFirst();
            Transaction.Operation operation = optionalOperation.orElseThrow(()
                    -> new OperationNotFoundExeption("Unknown operation " + operationFromFile));
            transaction.setOperation(operation);
            transactions.add(transaction);
        }
        return transactions;
    }
}
