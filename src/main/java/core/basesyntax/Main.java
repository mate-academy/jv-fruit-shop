package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationHandlerService;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParseService;
import core.basesyntax.service.TransactionProcessService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParseServiceImpl;
import core.basesyntax.service.impl.TransactionProcessServiceImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandlerService> strategyMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                FruitTransaction.Operation.RETURN, new ReturnHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        FileReaderService readFromFileService = new FileReaderServiceImpl();
        List<String> dataFromFile = readFromFileService.read(FILE_PATH);
        TransactionParseService transactionParseService = new TransactionParseServiceImpl();
        List<FruitTransaction> fruitTransactionList =
                transactionParseService.getTransactionData(dataFromFile);
        OperationStrategyService operationStrategyService = new OperationStrategyImpl(strategyMap);
        TransactionProcessService shopProcessService =
                new TransactionProcessServiceImpl(operationStrategyService);
        shopProcessService.processData(fruitTransactionList);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        FileWriterService csvFileWriterService = new FileWriterServiceImpl();
        csvFileWriterService.write(REPORT_PATH,report);
    }
}
