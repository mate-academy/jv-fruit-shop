package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReaderServiceImpl;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FileWriterServiceImpl;
import core.basesyntax.service.OperationProcess;
import core.basesyntax.service.OperationProcessImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<FruitTransaction.Operation, OperationHandler> OPERATION_HANDLER_MAP
            = new HashMap<>();
    private static final String INPUT_FILE_PATH = "src/main/resources/transactions.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    static {
        OPERATION_HANDLER_MAP.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        OPERATION_HANDLER_MAP.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        OPERATION_HANDLER_MAP.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        OPERATION_HANDLER_MAP.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
    }

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> dataFromFile = fileReaderService.readFromFile(INPUT_FILE_PATH);
        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactions
                = transactionParser.getFruitTransactions(dataFromFile);
        OperationProcess operationProcess = new OperationProcessImpl();
        operationProcess.processOperation(fruitTransactions);
        ReportService reportService = new ReportServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(reportService.createReport(), OUTPUT_FILE_PATH);
    }
}
