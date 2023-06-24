package core.basesyntax;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.TransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.TransactionStrategyImpl;
import core.basesyntax.strategy.transaction.BalanceHandler;
import core.basesyntax.strategy.transaction.PurchaseHandler;
import core.basesyntax.strategy.transaction.ReturnHandler;
import core.basesyntax.strategy.transaction.SupplyHandler;
import core.basesyntax.strategy.transaction.TransactionHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TransactionDao transactionDao = new TransactionDaoImpl();

        Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap
                = new HashMap<>();
        transactionHandlerMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceHandler(transactionDao));
        transactionHandlerMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler(transactionDao));
        transactionHandlerMap.put(
                FruitTransaction.Operation.RETURN, new ReturnHandler(transactionDao));
        transactionHandlerMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyHandler(transactionDao));

        TransactionStrategy transactionStrategy
                = new TransactionStrategyImpl(transactionHandlerMap);

        TransactionService transactionService = new TransactionServiceImpl();
        ReaderService readerService = new ReaderServiceImpl(transactionService);
        readerService.readInfoFromFile();

        WriterService writerService = new WriterServiceImpl();
        ReportService reportService = new ReportServiceImpl(transactionStrategy, writerService);
        reportService.countAmountOfFruits();
    }
}
