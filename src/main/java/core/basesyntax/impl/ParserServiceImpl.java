package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String CSV_SEPARATOR = ",";
    private static final int TRANSACTION_FIELDS_COUNT = 3;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : lines) {
            try {
                String[] transaction = line.split(CSV_SEPARATOR);
                if (transaction.length < TRANSACTION_FIELDS_COUNT) {
                    throw new RuntimeException("Invalid input format: insufficient fields");
                }
                transactions.add(new FruitTransaction(Operation
                        .getOperationByCode(transaction[OPERATION_INDEX]),
                        transaction[FRUIT_INDEX], Integer.parseInt(transaction[QUANTITY_INDEX])));
            } catch (Exception e) {
                throw new RuntimeException("Error parsing transaction: " + e.getMessage());
            }
        }
        return transactions;
    }
}
