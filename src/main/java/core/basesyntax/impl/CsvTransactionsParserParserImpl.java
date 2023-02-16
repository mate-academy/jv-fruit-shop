package core.basesyntax.impl;

import java.util.ArrayList;
import java.util.List;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvTransactionsParser;

public class CsvTransactionsParserParserImpl implements CsvTransactionsParser {
    private final int OPERATION_POSITION = 0;
    private final int FRUIT_POSITION = 1;
    private final int QUANTITY_POSITION = 2;
    private final int TITLE_POSITION = 1;
    private static final String DATA_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactions) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = TITLE_POSITION; i < transactions.size(); i++) {
            fruitTransactionList.add(parseLine(transactions.get(i)));
        }
        return fruitTransactionList;
    }

    private FruitTransaction parseLine(String line) {
        String[] data = line.split(DATA_SEPARATOR);
        return new FruitTransaction(
                FruitTransaction.Operation.getByCharacter(data[OPERATION_POSITION]),
                data[FRUIT_POSITION],
                Integer.parseInt(data[QUANTITY_POSITION]));
    }
}