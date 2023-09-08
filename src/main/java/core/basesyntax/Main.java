package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.impl.BalanceOperationHandler;
import core.basesyntax.service.operation.impl.PurchaseOperationHandler;
import core.basesyntax.service.operation.impl.ReturnOperationHandler;
import core.basesyntax.service.operation.impl.SupplyOperationHandler;
import core.basesyntax.service.service.impl.DataProcessImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationServiceMap = new HashMap<>();
        operationServiceMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationServiceMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationServiceMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        DataProcessImpl dataProcess = new DataProcessImpl(operationServiceMap);
        String fileFrom = "inputFile.csv";
        String fileTo = "outputFile.csv";
        dataProcess.processReport(fileFrom, fileTo);
    }

}
