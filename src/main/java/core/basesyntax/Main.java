package core.basesyntax;

import db.Storage;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import service.FruitTransactionService;
import service.impl.FruitTransactionServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceOperationHandler;
import strategy.FruitTransactionStrategy;
import strategy.FruitTransactionStrategyImpl;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> fruitTransactionMap = new HashMap<>();
        fruitTransactionMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        fruitTransactionMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        fruitTransactionMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        fruitTransactionMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());

        FruitTransactionStrategy transactionStrategy =
                new FruitTransactionStrategyImpl(fruitTransactionMap);
        Storage fruitsStorage = new Storage();
        FruitTransactionService fruitService =
                new FruitTransactionServiceImpl(transactionStrategy,fruitsStorage);

        fruitService.addToStorage(new ReaderServiceImpl().readFromFile());
        new WriterServiceImpl().writeToFile(new ReportServiceImpl()
                .createReport(fruitsStorage.getFruitsStorage()));
    }
}
