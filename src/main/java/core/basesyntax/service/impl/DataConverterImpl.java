package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final String SPLIT_SYMBOL = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int TITLE_LINE = 1;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .skip(TITLE_LINE)
                .map(line -> line.split(SPLIT_SYMBOL))
                .map(items ->
                        new FruitTransaction(Operation.getValueFromCode(items[OPERATION_INDEX]),
                                items[FRUIT_NAME_INDEX],
                                Integer.parseInt(items[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
