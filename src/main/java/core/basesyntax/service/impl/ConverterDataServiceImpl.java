package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConverterDataService;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterDataServiceImpl implements ConverterDataService {
    private static final String SEPARATOR = ",";
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int COUNT_INDEX = 2;
    private static final int SKIP_FIRST_LINE = 1;

    @Override
    public List<FruitTransaction> convertForTransaction(List<String> strings) {
        return strings.stream().skip(SKIP_FIRST_LINE)
                .map(this::convertString)
                .collect(Collectors.toList());
    }

    private FruitTransaction convertString(String string) {
        String[] fruitTransaction = string.split(SEPARATOR);
        return new FruitTransaction(FruitTransaction
                .findOperation(fruitTransaction[TRANSACTION_INDEX]),
                fruitTransaction[FRUIT_INDEX],
                Integer.parseInt(fruitTransaction[COUNT_INDEX]));
    }
}
