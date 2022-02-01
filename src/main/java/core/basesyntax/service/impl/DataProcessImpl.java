package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcess;
import core.basesyntax.service.OperationHendler;
import java.util.List;
import java.util.Map;

public class DataProcessImpl implements DataProcess {
    private FruitDao fruitDao;
    private Map<FruitTransaction.Operation,
            OperationHendler> operationHendlerMap;

    public DataProcessImpl(FruitDao fruitDao,
                           Map<FruitTransaction.Operation,
                                   OperationHendler> operationHendlerMap) {
        this.fruitDao = fruitDao;
        this.operationHendlerMap = operationHendlerMap;
    }

    @Override
    public void processingData(List<FruitTransaction> parseredData) {
        for (FruitTransaction fruitTransaction : parseredData) {
            operationHendlerMap.get(fruitTransaction.getOperation())
                    .getOperation(fruitDao, fruitTransaction);
        }
    }
}
