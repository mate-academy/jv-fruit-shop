package core.basesyntax.service.parser;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Product;
import core.basesyntax.model.Transaction;
import java.util.ArrayList;
import java.util.List;

public class FileEntryParserImpl implements FileEntryParser {
    private static final String CSV_FORMAT = "[b,s,r,p],[a-z]+,[0-9]+";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITERATOR = ",";
    private static final String EXCEPTION_MESSAGE = "Entry format should be " + CSV_FORMAT;

    @Override
    public List<Transaction> parseProduct(List<String> records) {
        List<Transaction> factories = new ArrayList<>();
        for (String record : records) {
            if (!record.matches(CSV_FORMAT)) {
                throw new RuntimeException(EXCEPTION_MESSAGE);
            }
            String[] fields = record.split(SPLITERATOR);
            Operation operation = Operation.getOperationByLetter(fields[OPERATION_INDEX]);
            Product fruit = new Product(fields[FRUIT_INDEX]);
            int amount = Integer.parseInt(fields[QUANTITY_INDEX]);
            Transaction product = new Transaction(operation, fruit, amount);
            factories.add(product);
        }
        return factories;
    }
}
