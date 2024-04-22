package core.basesyntax.service;

import core.basesyntax.operation.OperationProvider;
import core.basesyntax.operation.OperationProviderImpl;
import core.basesyntax.operation.StoreOperation;
import java.util.ArrayList;
import java.util.List;

public class OperationListProviderImpl implements OperationListProvider {
    private static final int OPERATION_POSITION = 0;
    private static final int COLUMN_NAMES_LINE_INDEX = 0;
    private static final int PRODUCT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private OperationProvider operationProvider = new OperationProviderImpl();

    @Override
    public List<StoreOperation> get(List<String> fileData) {
        if (fileData == null) {
            throw new RuntimeException("Input data is null");
        }
        fileData.remove(COLUMN_NAMES_LINE_INDEX);
        List<StoreOperation> operationsList = new ArrayList<>();
        for (String line : fileData) {
            String[] splitLine = line.split(",");            
            operationsList.add(createOperation(splitLine));
        }
        return operationsList;
    }

    private StoreOperation createOperation(String[] splitLine) {
        StoreOperation operation = new StoreOperation();
        operation.setOperation(operationProvider.get(splitLine[OPERATION_POSITION]));
        operation.setProduct(splitLine[PRODUCT_POSITION]);
        operation.setQuantity(Integer.parseInt(splitLine[QUANTITY_POSITION]));
        return operation;
    }
}
