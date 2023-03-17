package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserServiceImpl implements DataParserService {
    private static final String LINE_SPLITTER = ",";
    private static final byte OPERATION_INDEX = 0;
    private static final byte FRUIT_INDEX = 1;
    private static final byte QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseDataToFruitTransaction(List<String> data) {
        return data.stream()
                .skip(1)
                .map(d -> d.split(LINE_SPLITTER))
                .map(d -> new FruitTransaction(FruitTransaction
                    .Operation.getOperation(d[OPERATION_INDEX]),
                    d[FRUIT_INDEX], Integer.parseInt(d[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
