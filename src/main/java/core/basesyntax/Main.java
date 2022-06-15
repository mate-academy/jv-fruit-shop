package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ProcessorService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ProcessorServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.TransactionStrategyImpl;
import core.basesyntax.strategy.transaction.BalanceTransactionHandler;
import core.basesyntax.strategy.transaction.FruitTransaction;
import core.basesyntax.strategy.transaction.PurchaseTransactionHandler;
import core.basesyntax.strategy.transaction.ReturnTransactionHandler;
import core.basesyntax.strategy.transaction.SupplyTransactionHandler;
import core.basesyntax.strategy.transaction.TransactionHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionHandler> transactionHandlersMap =
                new HashMap<>();
        transactionHandlersMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransactionHandler());
        transactionHandlersMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionHandler());
        transactionHandlersMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionHandler());
        transactionHandlersMap.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionHandler());

        FruitDao dao = new FruitDaoImpl();
        TransactionStrategy strategy = new TransactionStrategyImpl(transactionHandlersMap);

        ReaderService readerService = new ReaderServiceImpl();
        ProcessorService processorService = new ProcessorServiceImpl(dao, strategy);
        ReportService reportService = new ReportServiceImpl(dao);
        WriterService writerService = new WriterServiceImpl();

        processorService.processData(readerService.readFile("src/main/resources/file.csv"));
        writerService.writeFile(reportService.writeReport(), "src/main/resources/report.csv");
    }
}
