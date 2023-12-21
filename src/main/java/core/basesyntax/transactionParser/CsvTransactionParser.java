package core.basesyntax.transactionParser;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;


import java.util.ArrayList;
import java.util.List;

public class CsvTransactionParser implements TransactionParser{
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] transaction = line.split(",");
            transactions.add(new FruitTransaction(Operation.valueOf(transaction[OPERATION_INDEX]),
                    transaction[FRUIT_INDEX], Integer.parseInt(transaction[QUANTITY_INDEX])));
        }
        return transactions;
    }

}

//TransactionParser parses list of rows from file into list of FruitTransaction class