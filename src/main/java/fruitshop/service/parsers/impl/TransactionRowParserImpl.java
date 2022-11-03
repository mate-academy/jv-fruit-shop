package fruitshop.service.parsers.impl;

import fruitshop.dao.FruitShopStorageDaoImpl;
import fruitshop.model.FruitTransaction;
import fruitshop.model.Operation;
import fruitshop.service.parsers.TransactionRowParser;
import java.util.List;

public class TransactionRowParserImpl implements TransactionRowParser {
    private static final int INDEX_FIRST_CHAR_OF_STRING = 0;
    private static final int INDEX_OF_ACTION = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final int INPUT_INFO_COLUMNS_COUNT = 3;
    private static final int OPERATION_ID_CHAR_LENGTH = 1;
    private final FruitShopStorageDaoImpl storageDao;
    private boolean balanced;
    private boolean firstRow = true;

    public TransactionRowParserImpl(FruitShopStorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    public void parse(List<List<String>> rows) {
        rows
                .stream()
                .map(row -> {
                    isTransactionRowValid(row);
                    Operation operation = Operation.getByValue(
                            row.get(INDEX_OF_ACTION).charAt(INDEX_FIRST_CHAR_OF_STRING)
                    );
                    isBalancedFirstOnly(operation);
                    String fruitName = row.get(INDEX_OF_FRUIT_NAME);
                    int quantity = Integer.parseInt(row.get(INDEX_OF_QUANTITY));
                    return new FruitTransaction(operation, fruitName, quantity);
                })
                .forEach(storageDao::add);
    }

    private static void isTransactionRowValid(List<String> row) {
        if (row.size() != INPUT_INFO_COLUMNS_COUNT) {
            throw new RuntimeException("Invalid csv input file row size! "
                    + "Must be: " + INPUT_INFO_COLUMNS_COUNT
                    + "Got: " + row.size());
        }
        if (row.get(INDEX_OF_ACTION).length() != OPERATION_ID_CHAR_LENGTH) {
            throw new RuntimeException("Invalid operation. "
                    + "Expected other form (from " + OPERATION_ID_CHAR_LENGTH
                    + "symbol/character). Got: " + row.get(INDEX_OF_ACTION).length());
        }
    }

    private void isBalancedFirstOnly(Operation operation) {
        if (firstRow && operation != Operation.BALANCE) {
            throw new RuntimeException("Operations must start from balance operations. "
                    + "Got: " + operation.getOperation());
        }
        firstRow = false;
        if (!balanced && operation != Operation.BALANCE) {
            balanced = true;
        } else if (balanced && operation == Operation.BALANCE) {
            throw new RuntimeException("After balance operations must follow other operations.");
        }
    }
}
