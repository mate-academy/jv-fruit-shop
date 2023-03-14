package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessService;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessServiceImpl implements ProcessService {
    private static final String COMMA = ",";
    private static final int TYPE_ACTION = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT_OF_FRUIT = 2;

    @Override
    public List<FruitTransaction> getTransactions(List<String> lines) {
        final int skipFirstLine = 1;
        return lines.stream()
                .skip(skipFirstLine)
                .map(s -> transformation(s))
                .collect(Collectors.toList());
    }

    private FruitTransaction transformation(String line) {
        String[] lineSplit = line.split(COMMA);
        return new FruitTransaction(FruitTransaction.Operation
                .getOperationByCode(lineSplit[TYPE_ACTION]),
                lineSplit[FRUIT], Integer.parseInt(lineSplit[AMOUNT_OF_FRUIT]));
    }
}
