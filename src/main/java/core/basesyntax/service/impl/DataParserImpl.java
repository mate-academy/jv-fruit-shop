package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserImpl implements DataParser {
    private static final String LINE_SPLITTER = ",";
    private static final byte OPERATION_INDEX = 0;
    private static final byte FRUIT_INDEX = 1;
    private static final byte QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseDataToFruitTransaction(List<String> data) {
        return data.stream()
            .map(d -> d.split(LINE_SPLITTER))
            .map(dat -> new FruitTransaction(FruitTransaction.getOperation(dat[OPERATION_INDEX]),
                    dat[FRUIT_INDEX], Integer.parseInt(dat[QUANTITY_INDEX])))
            .collect(Collectors.toList());
    }
}
