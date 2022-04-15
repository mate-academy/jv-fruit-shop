package core.basesyntax;

import core.basesyntax.cvswork.FileReaderImpl;
import core.basesyntax.cvswork.FileWriter;
import core.basesyntax.cvswork.FileWrittenImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParserImpl;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionServiceImpl;
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

public class Main {

    public static final String INPUT_FILE_PATH
            = "src/main/java/core/basesyntax/resourse/normalFile.cvs";
    public static final String REPORT_FILE_PATH
            = "src/main/java/core/basesyntax/resourse/outFile.cvs";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = getMap();
        TransactionStrategy strategy = new TransactionStrategyImpl(operationHandlerMap);
        List<String> transaction = new FileReaderImpl().read(INPUT_FILE_PATH);
        List<FruitTransaction> transactionList =
                new FruitTransactionParserImpl().parse(transaction);
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(strategy, fruitDao);
        fruitTransactionService.process(transactionList);
        FileWriter fileWriter = new FileWrittenImpl();
        fileWriter.write(REPORT_FILE_PATH);
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
