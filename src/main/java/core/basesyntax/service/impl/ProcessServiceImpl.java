package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessService;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessServiceImpl implements ProcessService {

    private static final String REGEX = ",";
    private static final int TYPE_ACTION = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT_OF_FRUIT = 2;
    private static final String IGNORE = "type";

    @Override
    public List<FruitTransaction> modelSetUp(List<String> list) {
        return list.stream()
                .filter(s -> s != null && !s.contains(IGNORE))
                .map(s -> transformation(s))
                .collect(Collectors.toList());

    }

    private FruitTransaction transformation(String line) {
        String[] lineSplit = line.split(REGEX);
        return new FruitTransaction(FruitTransaction.Operation
                .getOperationByCode(lineSplit[TYPE_ACTION]),
                lineSplit[FRUIT], Integer.parseInt(lineSplit[AMOUNT_OF_FRUIT]));
    }
}
