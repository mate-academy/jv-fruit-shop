package core.basesyntax.dao.report;

import core.basesyntax.dao.operation.BalanceOperation;
import core.basesyntax.dao.operation.Operation;
import core.basesyntax.dao.operation.OperationHandler;
import core.basesyntax.dao.operation.PurchaseOperation;
import core.basesyntax.dao.operation.ReturnOperation;
import core.basesyntax.dao.operation.SupplyOperation;
import core.basesyntax.dao.storagedao.FruitStorageDao;
import core.basesyntax.dao.storagedao.FruitStorageDaoImpl;
import core.basesyntax.dao.transaction.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public ReportCreatorImpl() {
        operationHandlerMap = new HashMap<>();

        operationHandlerMap.put(Operation.RETURN, new ReturnOperation());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperation());
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperation());
    }

    @Override
    public Map<String, Integer> updateStorage() {
        Map<String, Integer> reportMap = new HashMap<>();
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

        for (FruitTransaction fruitTransaction : fruitStorageDao.getAllTransaction()) {
            String fruitName = fruitTransaction.getName();

            Integer fruitTransactionQuantity = operationHandlerMap
                    .get(fruitTransaction.getOperation())
                    .useOperation(fruitTransaction.getQuantity());

            if (reportMap.containsKey(fruitName)) {
                if (reportMap.get(fruitName) + fruitTransactionQuantity >= 0) {
                    Integer oldValue = reportMap.get(fruitName);
                    Integer newValue = oldValue + fruitTransactionQuantity;
                    reportMap.put(fruitName, newValue);
                } else {
                    throw new RuntimeException("Don't have " + fruitTransaction.getQuantity()
                            + " " + fruitName);
                }

            } else {
                if (fruitTransactionQuantity > 0) {
                    reportMap.put(fruitName, fruitTransactionQuantity);
                } else {
                    throw new RuntimeException("Don't have " + fruitName);
                }
            }
        }
        return reportMap;
    }
}
