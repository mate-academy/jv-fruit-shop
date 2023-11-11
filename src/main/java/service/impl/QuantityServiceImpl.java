package service.impl;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import operation.OperationHendler;
import service.QuantityService;

public class QuantityServiceImpl implements QuantityService {
    private Map<Operation, OperationHendler> operationHendlerMap;

    public QuantityServiceImpl(Map<Operation, OperationHendler> operationHendlerMap) {
        this.operationHendlerMap = operationHendlerMap;
    }

    @Override
    public void calculateQuantityForFruits(List<FruitTransaction> fruitTransactions) {
        fruitTransactions
                .forEach(fruitTransaction -> operationHendlerMap
                        .get(fruitTransaction.getOperation())
                    .calculateQuantity(fruitTransaction));
    }
}
