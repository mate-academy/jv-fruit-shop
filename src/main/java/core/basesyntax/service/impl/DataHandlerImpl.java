package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class DataHandlerImpl implements DataHandler {

    private static final int OPERATION_POS = 0;
    private static final int FRUIT_TYPE_POS = 1;
    private static final int QUANTITY_POS = 2;
    private static final String SPLITTER = ",";
    private final OperationStrategy operationStrategy;

    public DataHandlerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processData(List<String> data) {
        for (String datum : data) {
            String[] splitedDatum = datum.split(SPLITTER);
            operationStrategy
                    .getOperationHandler(FruitTransaction.Operation
                            .parse(splitedDatum[OPERATION_POS]))
                    .doOperation(splitedDatum[FRUIT_TYPE_POS],
                            splitedDatum[QUANTITY_POS]);
        }
    }
}
