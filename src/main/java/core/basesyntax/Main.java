package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationHandlerOfBalance;
import core.basesyntax.service.operation.OperationHandlerOfPurchase;
import core.basesyntax.service.operation.OperationHandlerOfReturn;
import core.basesyntax.service.operation.OperationHandlerOfSupply;
import core.basesyntax.service.service.impl.DataProcessImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/inputFile.csv";
    private static final String OUTPUT_FILE = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationServiceMap = new HashMap<>();
        operationServiceMap.put(FruitTransaction.Operation.BALANCE,
                new OperationHandlerOfBalance());
        operationServiceMap.put(FruitTransaction.Operation.SUPPLY,
                new OperationHandlerOfSupply());
        operationServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new OperationHandlerOfPurchase());
        operationServiceMap.put(FruitTransaction.Operation.RETURN,
                new OperationHandlerOfReturn());

        DataProcessImpl dataProcess = new DataProcessImpl(operationServiceMap);
        dataProcess.processReport(INPUT_FILE, OUTPUT_FILE);
    }
}
