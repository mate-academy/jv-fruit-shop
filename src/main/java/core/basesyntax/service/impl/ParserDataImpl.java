package core.basesyntax.service.impl;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ParserData;

public class ParserDataImpl implements ParserData {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUALITY_INDEX = 2;
    public static final String CHAR_SPLIT = ",";

    @Override
    public Transaction parseData(String data) {
        String[] parseData = data.split(CHAR_SPLIT);
        return new Transaction(parseData[OPERATION_INDEX],
                new Fruit(parseData[FRUIT_INDEX]),
                Integer.parseInt(parseData[QUALITY_INDEX]));
    }
}
