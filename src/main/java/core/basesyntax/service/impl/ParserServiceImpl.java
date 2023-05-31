package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> fruitTransactions) {
        return fruitTransactions.stream()
                .map(line -> line.split(SEPARATOR))
                .map(lineArr -> new FruitTransaction(FruitTransaction.Operation
                        .getByCode(lineArr[OPERATION]),
                        lineArr[FRUIT_NAME],
                        Integer.parseInt(lineArr[QUANTITY])))
                .collect(Collectors.toList());
    }
}
