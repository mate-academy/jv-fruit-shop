package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.FruitTransactionStrategy;
import core.basesyntax.strategy.FruitTransactionStrategyImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

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
                new FruitTransactionServiceImpl(transactionStrategy, fruitsStorage);

        fruitService.setOperationHandler(new ParserServiceImpl()
                .getTransactionFromString(new ReaderServiceImpl()
                .readFromFile("src/main/resources/data.csv")));
        new WriterServiceImpl().writeToFile(new ReportServiceImpl()
                .createReport(fruitsStorage.getFruitsStorage()),"src/main/resources/report.csv");
    }
}
