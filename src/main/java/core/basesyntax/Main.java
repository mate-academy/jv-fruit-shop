package core.basesyntax;

import core.basesyntax.cvswork.FileReaderImpl;
import core.basesyntax.cvswork.FileWrite;
import core.basesyntax.cvswork.FileWrittenImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ManipulationService;
import core.basesyntax.service.ManipulationServiceImpl;
import core.basesyntax.service.TransactionStrategy;
import core.basesyntax.service.TransactionStrategyImpl;
import core.basesyntax.service.operation.BalanceOperation;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperation;
import core.basesyntax.service.operation.ReturnOperation;
import core.basesyntax.service.operation.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static final String INPUT_FILE_PATH
            = "src/main/java/core/basesyntax/resourse/inputFile.cvs";
    public static final String REPORT_FILE_PATH
            = "src/main/java/core/basesyntax/resourse/outFile.cvs";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = getMap();
        TransactionStrategy strategy = new TransactionStrategyImpl(operationHandlerMap);
        List<FruitTransaction> transactionList = new FileReaderImpl().readParser(INPUT_FILE_PATH);
        ManipulationService manipulationService = new ManipulationServiceImpl(strategy);
        manipulationService.manipulation(transactionList);
        FileWrite fileWriter = new FileWrittenImpl();
        fileWriter.writeFile(REPORT_FILE_PATH);
    }

    private static Map<FruitTransaction.Operation, OperationHandler> getMap() {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        return operationHandlerMap;
    }
}
