package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParsingService;
import java.util.ArrayList;
import java.util.List;

public class ParsingServiceImpl implements ParsingService {
    private static final int TYPE_OF_TRANSACTION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final String COMMA = ",";

    @Override
    public List<FruitTransaction> createTransactions(List<String> strings) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String oneLine : strings) {
            String[] splitted = oneLine.split(COMMA);
            transactions.add(new FruitTransaction(splitted[TYPE_OF_TRANSACTION],
                        splitted[TYPE_OF_FRUIT], Integer.parseInt(splitted[AMOUNT])));
        }
        return transactions;
    }
}
