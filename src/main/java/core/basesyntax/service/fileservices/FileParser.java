package core.basesyntax.service.fileservices;

import core.basesyntax.model.FruitsTransaction;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int TITLE_INDEX = 0;

    public List<FruitsTransaction> parseData(List<String> dataFromFile) {
        dataFromFile.remove(TITLE_INDEX);
        List<FruitsTransaction> operationList = new ArrayList<>();
        for (String record : dataFromFile) {
            String[] array = record.split(SEPARATOR);
            FruitsTransaction operation = new FruitsTransaction();
            operation.setOperation(
                    FruitsTransaction.Operation.fromString(array[OPERATION_INDEX]));
            operation.setFruit(array[FRUIT_INDEX]);
            operation.setQuantity(Integer.parseInt(array[QUANTITY_INDEX]));
            operationList.add(operation);
        }
        return operationList;
    }
}

