package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationMapper;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_TYPE_COLUMN_INDEX = 0;
    private static final int FRUIT_NAME_COLUMN_INDEX = 1;
    private static final int QUANTITY_COLUMN_INDEX = 2;
    private static final String CSV_COLUMNS_SPLITTER = ",";

    private static final OperationMapper DATA_SUPPLIER_SERVICE = new OperationMapperImpl();

    public List<Transaction> parse(List<String> data) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] column = data.get(i).split(CSV_COLUMNS_SPLITTER);
            Transaction transaction = new Transaction();
            String operationFromFile = column[OPERATION_TYPE_COLUMN_INDEX];
            transaction.setFruit(new Fruit(column[FRUIT_NAME_COLUMN_INDEX]));
            transaction.setSum(Integer.parseInt(column[QUANTITY_COLUMN_INDEX]));
            transaction.setOperation(DATA_SUPPLIER_SERVICE.mapToEnumValue(operationFromFile));
            transactions.add(transaction);
        }
        return transactions;
    }
}
