package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.ResultData;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public ResultData handle(FruitTransaction transaction) {
        return new ResultData(transaction.getFruit(), transaction.getQuantity());
    }
}
