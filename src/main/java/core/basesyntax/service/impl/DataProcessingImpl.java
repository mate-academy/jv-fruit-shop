package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.OperationStrategy;
import core.basesyntax.operations.OperationStrategyImpl;
import core.basesyntax.service.DataProcessing;
import java.util.List;
import java.util.Map;

public class DataProcessingImpl implements DataProcessing {
    private static final int FIRST_DATA = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int PRODUCT_AMOUNT_INDEX = 2;
    private String columnsNamesLine;
    private final Map<String, OperationHandler> operations;
    private final FruitsDao fruitsDao;

    public DataProcessingImpl(Map<String, OperationHandler> operations) {
        fruitsDao = new FruitsDaoImpl();
        this.operations = operations;
    }

    @Override
    public FruitsDao processData(List<String> fileData) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(operations);
        columnsNamesLine = fileData.get(0);
        for (int i = FIRST_DATA; i < fileData.size(); i++) {
            String[] lineData = fileData.get(i).split(",");
            int quantity = Integer.parseInt(lineData[PRODUCT_AMOUNT_INDEX]);
            operationStrategy.getOperation(lineData[OPERATION_INDEX])
                    .processLineData(lineData[PRODUCT_NAME_INDEX], quantity, fruitsDao);
        }
        return fruitsDao;
    }

    @Override
    public String getColumnsNamesLine() {
        return columnsNamesLine;
    }
}
