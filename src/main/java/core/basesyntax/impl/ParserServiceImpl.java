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

    @Override
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : lines) {
            String[] transaction = line.split(CSV_SEPARATOR);
            transactions.add(new FruitTransaction(Operation
                    .getOperationByCode(transaction[OPERATION_INDEX]),
                    transaction[FRUIT_INDEX], Integer.parseInt(transaction[QUANTITY_INDEX])));
        }
        return transactions;
    }
}
