package core.basesyntax;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReport;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.TransactionsService;
import core.basesyntax.service.TransferToStorage;
import core.basesyntax.service.impl.CreateReportImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.TransactionsServiceImpl;
import core.basesyntax.service.impl.TransferToStorageImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.impl.AdditionOperationHandler;
import core.basesyntax.strategy.handler.impl.SubtractionOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        ReaderService readerService = new ReaderServiceImpl();
        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE,
                new AdditionOperationHandler(fruitShopDao));
        handlerMap.put(FruitTransaction.Operation.SUPPLY,
                new AdditionOperationHandler(fruitShopDao));
        handlerMap.put(FruitTransaction.Operation.PURCHASE,
                new SubtractionOperationHandler(fruitShopDao));
        handlerMap.put(FruitTransaction.Operation.RETURN,
                new AdditionOperationHandler(fruitShopDao));
        TransactionsService transactionsService =
                new TransactionsServiceImpl(readerService.getLines());
        TransferToStorage transferToStorage =
                new TransferToStorageImpl(new OperationStrategy(handlerMap));
        transferToStorage.transfer(transactionsService.getFruitTransactions());
        CreateReport createReport = new CreateReportImpl(fruitShopDao);
        WriterServiceImpl writerService = new WriterServiceImpl();
        writerService.writeToFile(createReport);
    }
}
