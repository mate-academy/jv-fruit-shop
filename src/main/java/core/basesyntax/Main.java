package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationProcess;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.OperationProcessImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.OperationHandlerStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/transactions.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";
    private static final Map<FruitTransaction.Operation, OperationHandler> OPERATION_HANDLER_MAP
            = new HashMap<>();
    private static final FruitDao fruitDao = new FruitDaoImpl();

    static {
        OPERATION_HANDLER_MAP.put(FruitTransaction.Operation.SUPPLY,
                new SupplyHandler(fruitDao));
        OPERATION_HANDLER_MAP.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandler(fruitDao));
        OPERATION_HANDLER_MAP.put(FruitTransaction.Operation.RETURN,
                new ReturnHandler(fruitDao));
        OPERATION_HANDLER_MAP.put(FruitTransaction.Operation.BALANCE,
                new BalanceHandler(fruitDao));
    }

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        OperationHandlerStrategy operationHandlerStrategy
                = new OperationHandlerStrategyImpl(OPERATION_HANDLER_MAP);
        OperationProcess operationProcess = new OperationProcessImpl(operationHandlerStrategy);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        ReportService reportService = new ReportServiceImpl();

        List<String> dataFromFile = fileReaderService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions
                = transactionParser.getFruitTransactions(dataFromFile);
        operationProcess.processOperation(fruitTransactions);
        fileWriterService.writeToFile(reportService.createReport(), OUTPUT_FILE_PATH);
    }
}
