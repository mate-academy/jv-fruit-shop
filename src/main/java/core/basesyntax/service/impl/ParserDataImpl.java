package core.basesyntax.service.impl;

import core.basesyntax.dto.Transaction;
import core.basesyntax.service.ParserData;

public class ParserDataImpl implements ParserData {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUALITY_INDEX = 2;

    @Override
    public Transaction parseData(String data) {
        String[] parseData = data.split(",");
        if (parseData.length != 3) {
            throw new RuntimeException("incorrect data");
        }
        return new Transaction(parseData[OPERATION_INDEX],
                parseData[FRUIT_INDEX],
                Integer.parseInt(parseData[QUALITY_INDEX]));
    }
}
