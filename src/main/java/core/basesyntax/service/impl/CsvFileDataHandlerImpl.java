package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.operations.OperationStrategy;
import core.basesyntax.service.CsvFileDataHandler;
import java.util.List;

public class CsvFileDataHandlerImpl implements CsvFileDataHandler {
    private static final int FIRST_DATA = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int PRODUCT_AMOUNT_INDEX = 2;
    private final FruitsDao fruitsDao;
    private final OperationStrategy operationStrategy;

    public CsvFileDataHandlerImpl(OperationStrategy operationStrategy) {
        fruitsDao = new FruitsDaoImpl();
        this.operationStrategy = operationStrategy;
    }

    @Override
    public FruitsDao processData(List<String> fileData) {
        for (int i = FIRST_DATA; i < fileData.size(); i++) {
            String[] lineData = fileData.get(i).split(",");
            int quantity = Integer.parseInt(lineData[PRODUCT_AMOUNT_INDEX]);
            operationStrategy.getOperation(lineData[OPERATION_INDEX])
                    .process(lineData[PRODUCT_NAME_INDEX], quantity);
        }
        return fruitsDao;
    }
}
