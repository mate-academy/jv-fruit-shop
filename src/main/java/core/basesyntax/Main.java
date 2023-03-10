package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionExecutor;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionExecutorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE_PATH = "src/main/resources/input_file.csv";
    public static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        String inputData = "type,fruit,quantity,\n"
                + "b,banana,20,\n"
                + "b,apple,100,\n"
                + "s,banana,100,\n"
                + "p,banana,13,\n"
                + "r,apple,10,\n"
                + "p,apple,20,\n"
                + "p,banana,5,\n"
                + "s,banana,50";

        WriterService writerService = new WriterServiceImpl();
        writerService.writeDataToFile(inputData, INPUT_FILE_PATH);

        ReaderService readerService = new ReaderServiceImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactionList = transactionParser
                .parse(readerService.readFromFile(INPUT_FILE_PATH));
        System.out.println(fruitTransactionList);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        TransactionExecutor executor = new TransactionExecutorImpl(operationStrategy);
        executor.execute(fruitTransactionList);
        System.out.println(Storage.fruitStorage);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        System.out.println(report);

        writerService.writeDataToFile(report, REPORT_FILE_PATH);
    }
}
