package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.LineParserService;
import java.util.List;
import java.util.stream.Collectors;

public class LineParserServiceImpl implements LineParserService {
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_FOR_FRUIT = 1;
    private static final int INDEX_FOR_AMOUNT = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        lines.remove(INDEX_ZERO);
        return lines.stream()
                .map(l -> l.split(SEPARATOR))
                .map(s -> {
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setOperation(FruitTransaction.Operation
                            .getOperation(s[INDEX_ZERO]));
                    fruitTransaction.setFruit((s[INDEX_FOR_FRUIT]));
                    fruitTransaction.setQuantity(Integer.parseInt(s[INDEX_FOR_AMOUNT]));
                    return fruitTransaction;
                })
                .collect(Collectors.toList());
    }
}
