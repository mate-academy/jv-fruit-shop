package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransactions(List<String> fileLines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String fileLine : fileLines) {
            if (fileLine.isEmpty()) {
                continue;
            }
            String[] information = fileLine.split(SEPARATOR);
            int amount = 0;
            try {
                amount = Integer.parseInt(information[QUANTITY]);
            } catch (NumberFormatException e) {
                throw new RuntimeException(
                        "Invalid quantity of product: "
                                + information[QUANTITY]);
            }
            fruitTransactions.add(new FruitTransaction(
                    Operation.getByCode(information[OPERATION_TYPE]),
                    information[FRUIT].toLowerCase(),
                    amount));
        }
        return fruitTransactions;
    }
}
