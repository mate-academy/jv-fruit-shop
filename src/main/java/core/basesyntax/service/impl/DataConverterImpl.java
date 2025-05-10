package core.basesyntax.service.impl;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.ShopOperation;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int LIST_START = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA = ",";

    @Override
    public List<ShopOperation> convertToOperation(List<String> reportList) {
        List<ShopOperation> shopOperationList = new ArrayList<>();
        for (String line : reportList.subList(LIST_START, reportList.size())) {
            String[] parts = line.split(COMMA);
            String codeOperation = parts[OPERATION_INDEX];
            String fruit = parts[FRUIT_INDEX];
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            shopOperationList.add(
                    new ShopOperation(OperationType.getOperationType(codeOperation),
                            fruit, quantity));
        }
        return shopOperationList;
    }
}
