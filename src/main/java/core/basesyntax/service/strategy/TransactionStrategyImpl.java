package core.basesyntax.service.strategy;

import core.basesyntax.dao.AdditionOperationHandler;
import core.basesyntax.dao.RemovalOperationHandler;
import core.basesyntax.dao.dao.impl.BalanceOperationImpl;
import core.basesyntax.dao.dao.impl.PurchaseTransactionImpl;
import core.basesyntax.dao.dao.impl.ReturnOperationImpl;
import core.basesyntax.dao.dao.impl.SupplyOperationImpl;
import core.basesyntax.model.OperationModel;
import java.util.List;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final AdditionOperationHandler balanceOperation = new BalanceOperationImpl();
    private final AdditionOperationHandler supplyOperation = new SupplyOperationImpl();
    private final AdditionOperationHandler returnOperation = new ReturnOperationImpl();
    private final RemovalOperationHandler purchaseOperation = new PurchaseTransactionImpl();

    @Override
    public void transactionOperator(List<OperationModel> operationList) {
        for (OperationModel model : operationList) {
            if (model.getOperation().equals(OperationModel.Operation.BALANCE)) {
                balanceOperation.addToStorage(model.getFruit(), model.getQuantity());
            } else if (model.getOperation().equals(OperationModel.Operation.PURCHASE)) {
                purchaseOperation.getFruitFromStorage(model.getFruit(), model.getQuantity());
            } else if (model.getOperation().equals(OperationModel.Operation.RETURN)) {
                returnOperation.addToStorage(model.getFruit(), model.getQuantity());
            } else if (model.getOperation().equals(OperationModel.Operation.SUPPLY)) {
                supplyOperation.addToStorage(model.getFruit(), model.getQuantity());
            } else {
                throw new RuntimeException("Not valid transaction");
            }
        }
    }
}
