package core.basesyntax.service.imp;

import core.basesyntax.model.GoodsOperation;
import core.basesyntax.service.CsvParseService;
import java.util.ArrayList;

public class CsvParser implements CsvParseService {
    private static final String LINE_DIVIDER = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int OPERATION_ITEM_INDEX = 1;
    private static final int OPERATION_QUANTITY_INDEX = 2;

    @Override
    public ArrayList<GoodsOperation> listOperationsFromCsv(ArrayList<String> csvOperationsList) {
        ArrayList<GoodsOperation> operationsList = new ArrayList<>();
        for (int i = 1; i < csvOperationsList.size(); i++) {
            String csvOperation = csvOperationsList.get(i);
            GoodsOperation operation = convertToOperationFromCsv(csvOperation);
            operationsList.add(operation);
        }
        return operationsList;
    }

    @Override
    public GoodsOperation convertToOperationFromCsv(String operation) {
        String [] line = operation.split(LINE_DIVIDER);
        GoodsOperation.TransactionType type = GoodsOperation.TransactionType
                .getByCode(line[OPERATION_TYPE_INDEX]);
        String item = line[OPERATION_ITEM_INDEX];
        int quantity = Integer.parseInt(line[OPERATION_QUANTITY_INDEX]);
        return new GoodsOperation(type, item, quantity);
    }
}
