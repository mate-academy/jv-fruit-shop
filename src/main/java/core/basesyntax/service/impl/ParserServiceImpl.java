package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int TITLE_INDEX = 0;

    @Override
    public List<FruitTransaction> parseData(List<String> dataFromFile) {
        dataFromFile.remove(TITLE_INDEX);
        List<FruitTransaction> operationList = new ArrayList<>();
        for (String record : dataFromFile) {
            String[] array = record.split(SEPARATOR);
            FruitTransaction operation = new FruitTransaction();
            operation.setOperation(
                    FruitTransaction.Operation.fromString(array[OPERATION_INDEX]));
            operation.setFruit(array[FRUIT_INDEX]);
            operation.setQuantity(Integer.parseInt(array[QUANTITY_INDEX]));
            operationList.add(operation);
        }
        return operationList;
    }
}
