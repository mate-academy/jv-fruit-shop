package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(String data) {
        String[] dataFruitTransactions = data.split(System.lineSeparator());
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < dataFruitTransactions.length; i++) {
            transactions.add(parseLine(dataFruitTransactions[i]));
        }
        return transactions;
    }

    private FruitTransaction parseLine(String line) {
        String[] transactionLine = line.split(",");

        return new FruitTransaction(
                Operation.getByCode(transactionLine[TYPE_INDEX]),
                transactionLine[FRUIT_NAME_INDEX],
                Integer.parseInt(transactionLine[AMOUNT_INDEX]));
    }
}
