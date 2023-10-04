package core.basesyntax.service.impl;

import core.basesyntax.fruit.Operation;
import core.basesyntax.fruit.Transaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class CsvParserImpl implements Parser {
    private static final String SEPARATOR_IN_LINE = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_VALUE = 2;

    @Override
    public List<Transaction> parse(List<String> data) {
        List<Transaction> result = new ArrayList<>();
        for (String current : data) {
            Transaction transaction = new Transaction();
            String[] fields = current.split(SEPARATOR_IN_LINE);
            transaction.setOperation(Operation.getByCode(fields[OPERATION_INDEX]));
            transaction.setProduct(fields[FRUIT_NAME]);
            transaction.setQuantity(Integer.parseInt(fields[FRUIT_VALUE]));
            result.add(transaction);
        }
        return result;
    }
}
