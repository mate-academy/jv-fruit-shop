package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransform;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransformImpl implements FruitTransform {
    private static final String SEPARATOR = ",";
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int SKIP_LINES_NUMBER = 1;

    @Override
    public List<FruitTransaction> transform(List<String> strings) {
        return strings.stream().skip(SKIP_LINES_NUMBER)
                .map(this::transformString)
                .collect(Collectors.toList());
    }

    private FruitTransaction transformString(String string) {
        String[] fruitTransaction = string.split(SEPARATOR);
        return new FruitTransaction(FruitTransaction
                .getOperationByString(fruitTransaction[TRANSACTION_INDEX]),
                fruitTransaction[FRUIT_INDEX],
                Integer.parseInt(fruitTransaction[AMOUNT_INDEX]));
    }
}
