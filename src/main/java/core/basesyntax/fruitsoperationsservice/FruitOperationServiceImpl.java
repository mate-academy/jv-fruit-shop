package core.basesyntax.fruitsoperationsservice;

import core.basesyntax.kindoffruitsstorage.KindOfFruitsStack;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.typeofoperationhandler.operationservice.OperationHandler;
import java.util.ArrayList;
import java.util.List;

public class FruitOperationServiceImpl implements FruitsOperationService {
    private OperationHandler operationHandler;

    public FruitOperationServiceImpl(OperationHandler operationHandler) {
        this.operationHandler = operationHandler;
    }

    @Override
    public List<Operation> prepareProcessedDataToReport() {
        List<Operation> result = new ArrayList<>();
        for (int i = 0; i < KindOfFruitsStack.kindOfFruits.size(); i++) {
            String fruit = KindOfFruitsStack.kindOfFruits.get(i);
            Integer balanceValue = operationHandler.getOperationHandler(TypeOfOperation.b)
                    .getSumOfOperation(fruit);
            if (balanceValue > 0) {
                Operation operation = new Operation();
                operation.setFruit(fruit);
                operation.setQuantity(balanceValue - operationHandler
                        .getOperationHandler(TypeOfOperation.p)
                        .getSumOfOperation(fruit) - operationHandler
                        .getOperationHandler(TypeOfOperation.r)
                        .getSumOfOperation(fruit)
                        + operationHandler.getOperationHandler(TypeOfOperation.s)
                        .getSumOfOperation(fruit));
                result.add(operation);
            } else {
                throw new RuntimeException("The balance value is negative.");
            }
        }
        return result;
    }
}
