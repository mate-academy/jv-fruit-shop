package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final String SEPARATOR_IN_LINE = ",";
    private static final int INDEX_FOR_OPERATION_IN_STRING = 0;
    private static final int INDEX_FOR_PRODUCT_NAME_IN_STRING = 1;
    private static final int INDEX_FOR_PRODUCT_VALUE_IN_STRING = 2;

    public FruitTransactionServiceImpl() {
    }

    @Override
    public void greatFruitTransaction(List<String> dataFromFile,
                                      Map<FruitTransaction.Operation, OperationHandler>
                                              operationHandlerMap) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        for (String current : dataFromFile) {
            String[] line = current.split(SEPARATOR_IN_LINE);
            fruitTransaction.setOperation(fruitTransaction.getOperationByCode(
                    line[INDEX_FOR_OPERATION_IN_STRING]));
            fruitTransaction.setFruit(
                    line[INDEX_FOR_PRODUCT_NAME_IN_STRING]);
            fruitTransaction.setQuantity(Integer.parseInt(
                    line[INDEX_FOR_PRODUCT_VALUE_IN_STRING]));
            operationHandlerMap.get(fruitTransaction.getOperation())
                    .operationHandler(fruitTransaction);
        }
    }
}

