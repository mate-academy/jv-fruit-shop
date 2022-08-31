package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.strategy.Strategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParserServiceImpl implements ParserService {
    private static final String DIVIDER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final Map<String, Strategy> strategies;

    public ParserServiceImpl(Map<String, Strategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public List<Transaction> parse(List<String> strings) {
        List<Transaction> transactions = new ArrayList<>();
        for (String string : strings) {
            String[] stringParts = string.split(DIVIDER);
            transactions.add(
                    new Transaction(
                            strategies.get(stringParts[OPERATION_INDEX]),
                            stringParts[NAME_INDEX],
                            Integer.parseInt(stringParts[AMOUNT_INDEX]))
            );
        }
        return transactions;
    }
}
