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

    @Override
    public List<FruitTransaction> process(List<String> list) {
        return list.stream()
                .map(s -> transformation(s))
                .collect(Collectors.toList());

    }

    private FruitTransaction transformation(String string) {
        String[] stringSplit = string.split(REGEX);
        return new FruitTransaction(FruitTransaction.Operation
                .getOperationByCode(stringSplit[TYPE_ACTION]),
                stringSplit[FRUIT], Integer.parseInt(stringSplit[AMOUNT_OF_FRUIT]));
    }
}
