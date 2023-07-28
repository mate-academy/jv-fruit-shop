package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String DELIMITER = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OFFSET = 1;

    @Override
    public List<FruitTransaction> convertData(List<String> dataFromFile) {
        List<FruitTransaction> result = new ArrayList<>();
        for (int i = OFFSET; i < dataFromFile.size(); i++) {
            if (dataFromFile.get(i).isEmpty()) {
                break;
            }
            String[] splitData = dataFromFile.get(i).trim().split(DELIMITER);
            result.add(new FruitTransaction(splitData[OPERATION_TYPE_INDEX],
                    splitData[FRUIT_INDEX],
                    Integer.parseInt(splitData[QUANTITY_INDEX])));
        }
        return result;
    }
}
