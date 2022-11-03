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
    private final FruitShopStorageDaoImpl storageDao;
    private boolean balanced;
    private boolean firstRow = true;

    public TransactionRowParserImpl(FruitShopStorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    public void parse(List<List<String>> rows) {
        rows
                .stream()
                .map(cell -> {
                    isTransactionRowValid(cell);
                    Operation operation = Operation.getByValue(
                            cell.get(INDEX_OF_ACTION).charAt(INDEX_FIRST_CHAR_OF_STRING)
                    );
                    isBalancedFirstOnly(operation);
                    String fruitName = cell.get(INDEX_OF_FRUIT_NAME);
                    int quantity = Integer.parseInt(cell.get(INDEX_OF_QUANTITY));
                    return new FruitTransaction(operation, fruitName, quantity);
                })
                .forEach(storageDao::add);
    }

    private static void isTransactionRowValid(List<String> cell) {
        if (cell.size() != INPUT_INFO_COLUMNS_COUNT) {
            throw new RuntimeException("Wd");
        }
        if (cell.get(INDEX_OF_ACTION).length() != INDEX_OF_FRUIT_NAME) {
            throw new RuntimeException("!!!");
        }
    }

    private void isBalancedFirstOnly(Operation operation) {
        if (firstRow && operation != Operation.BALANCE) {
            throw new RuntimeException("!!!");
        }
        firstRow = false;
        if (!balanced && operation != Operation.BALANCE) {
            balanced = true;
        } else if (balanced && operation == Operation.BALANCE) {
            throw new RuntimeException("!!!");
        }
    }
}
