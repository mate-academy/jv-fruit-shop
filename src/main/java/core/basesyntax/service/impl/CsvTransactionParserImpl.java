package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CsvTransactionParserImpl implements TransactionParser {
    private static final int FIRST_LINE_TO_READ = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String REGEX_FORMAT = ",";
    private static final int FIRST_LINE = 0;
    private static final String FIRST_LINE_FORMAT = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> fruitTransaction(List<String> lines) {
        if (!lines.get(FIRST_LINE).equals(FIRST_LINE_FORMAT)) {
            throw new RuntimeException("Wrong data format. "
                    + "First line should be \"fruit,quantity\"");
        }
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = FIRST_LINE_TO_READ; i < lines.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] separatedData = lines.get(i).split(REGEX_FORMAT);
            try {
                fruitTransaction.setOperation(FruitTransaction.Operation
                        .getByCode(separatedData[OPERATION_INDEX]));
                fruitTransaction.setFruit(separatedData[FRUIT_INDEX]);
                fruitTransaction.setQuantity(Integer.parseInt(separatedData[QUANTITY_INDEX]));
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Wrong data format " + e);
            }
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
