package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;

    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(s -> s.replaceAll("\\s+", "").split(","))
                .map(e -> new FruitTransaction(FruitTransaction
                        .Operation.BALANCE.getOperationFromString(e[ZERO_INDEX]),
                        new Fruit(e[FIRST_INDEX],
                                Integer.parseInt(e[SECOND_INDEX]))))
                .collect(Collectors.toList());
    }
}
