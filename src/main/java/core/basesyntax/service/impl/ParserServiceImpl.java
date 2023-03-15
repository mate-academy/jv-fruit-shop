package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int COUNT_OF_SKIPPING_ROWS = 1;

    @Override
    public List<FruitTransaction> parse(List<String> strings) {
        return strings.stream()
                .skip(COUNT_OF_SKIPPING_ROWS)
                .map(s -> s.split(SEPARATOR))
                .map(s -> new FruitTransaction(FruitTransaction.Operation
                        .getOperation(s[OPERATION_INDEX]),
                        s[FRUIT_INDEX], Integer.parseInt(s[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
