package service.impl;

import dao.FruitStorageDao;
import java.util.ArrayList;
import model.InputDataType;
import service.TransactionOperation;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class TransactionOperationImpl implements TransactionOperation {
    @Override
    public void execute(ArrayList<InputDataType> inputData,
                        FruitStorageDao storage) {
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        for (InputDataType data : inputData) {
            operationStrategy.get(data.getOperation()).handle(data.getFruit(), storage);
        }
    }
}
