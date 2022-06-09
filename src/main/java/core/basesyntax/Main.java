package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.SplitService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataValidatorImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.SplitServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.BalanceHandler;
import core.basesyntax.strategy.handler.LeftoversHandler;
import core.basesyntax.strategy.handler.LeftoversHandlerImpl;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseHandler;
import core.basesyntax.strategy.handler.ReturnHandler;
import core.basesyntax.strategy.handler.SupplyHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_NAME = "src/main/resources/transaction.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        SplitService splitService = new SplitServiceImpl(new DataValidatorImpl());
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
        FruitTransactionService transactionService =
                new FruitTransactionServiceImpl(fruitTransactionDao, splitService);
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        List<String> dataFromCsv = readerService.readFromFile(FILE_NAME);
        transactionService.addTransaction(dataFromCsv);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReportService reportService = new ReportServiceImpl(fruitTransactionDao);
        LeftoversHandler leftoversHandler = new LeftoversHandlerImpl(operationStrategy);
        String leftovers = leftoversHandler.getLeftovers(fruitTransactionDao.get());
        String report = reportService.getReport(leftovers);
        WriterService writerService = new WriterServiceImpl();
        writerService.write(report, REPORT_PATH);
    }
}
