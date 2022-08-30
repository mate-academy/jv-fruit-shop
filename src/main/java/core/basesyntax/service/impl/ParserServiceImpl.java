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

    @Override
    public List<Transaction> parse(List<String> strings, Map<String, Strategy> strategies) {
        List<Transaction> transactions = new ArrayList<>();
        for (String string : strings) {
            transactions.add(
                    new Transaction(
                            strategies.get(string.split(DIVIDER)[OPERATION_INDEX]),
                            string.split(DIVIDER)[NAME_INDEX],
                            Integer.parseInt(string.split(DIVIDER)[AMOUNT_INDEX]))
            );
        }
        return transactions;
    }
}
