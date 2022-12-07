package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FileReadService;
import core.basesyntax.services.FileWriteService;
import core.basesyntax.services.ReportCreaterService;
import core.basesyntax.services.TransactionParser;
import core.basesyntax.services.imp.ParserServiceImpl;
import core.basesyntax.services.imp.ReaderServiceImpl;
import core.basesyntax.services.imp.ReportCreaterServiceImp;
import core.basesyntax.services.imp.WriterServiceImpl;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.Strategy;
import core.basesyntax.strategy.handlers.impl.BalanceOperationHandler;
import core.basesyntax.strategy.handlers.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.handlers.impl.ReturnOperationHandler;
import core.basesyntax.strategy.handlers.impl.StrategyImp;
import core.basesyntax.strategy.handlers.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        FileReadService readerService = new ReaderServiceImpl();
        List<String> list = readerService
                .readFromFile("src/main/java/core/basesyntax/resources/fruits.csv");
        TransactionParser parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parse(list);
        Strategy strategy = new StrategyImp(handlers);
        for (FruitTransaction fruitTransaction: fruitTransactions) {
            strategy.getHandler(fruitTransaction).handle(fruitTransaction);
        }
        ReportCreaterService createrService = new ReportCreaterServiceImp();
        String report = createrService.createReport();
        FileWriteService writerService = new WriterServiceImpl();
        writerService
                .writeReportToFile("src/main/java/core/basesyntax/resources/FileName.csv",report);
    }
}
