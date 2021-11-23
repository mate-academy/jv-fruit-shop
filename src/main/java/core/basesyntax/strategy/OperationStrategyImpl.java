package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.operation.Balance;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.Purchase;
import core.basesyntax.service.operation.Return;
import core.basesyntax.service.operation.Supply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy<TransactionDto> {

    @Override
    public void get(List<TransactionDto> transactions) {
        FruitStorageDao dao = new FruitStorageDaoImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("p", new Purchase(dao));
        operationHandlerMap.put("b", new Balance(dao));
        operationHandlerMap.put("r", new Return(dao));
        operationHandlerMap.put("s", new Supply(dao));

        for (TransactionDto transaction : transactions) {
            String operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.apply(transaction.getName(), transaction.getQuantity());
        }
    }
}
