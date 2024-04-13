package core.basesyntax;

import core.basesyntax.strategy.FruitBalance;
import core.basesyntax.strategy.FruitHandler;
import core.basesyntax.strategy.FruitPurchase;
import core.basesyntax.strategy.FruitReturn;
import core.basesyntax.strategy.FruitSupply;
import core.basesyntax.strategy.FruitsTransactionStrategy;
import core.basesyntax.strategy.FruitsTransactionStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String FILE_TO_READ_PATH = "src/main/resources/file.csv";
    private static final String FILE_TO_WRITE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, FruitHandler> fruitHandlerMap = new HashMap<>();
        fruitHandlerMap.put(FruitTransaction.Operation.BALANCE.getCode(), new FruitBalance());
        fruitHandlerMap.put(FruitTransaction.Operation.PURCHASE.getCode(), new FruitPurchase());
        fruitHandlerMap.put(FruitTransaction.Operation.SUPPLY.getCode(), new FruitSupply());
        fruitHandlerMap.put(FruitTransaction.Operation.RETURN.getCode(), new FruitReturn());

        FruitsTransactionStrategy fruitsTransactionStrategy = new FruitsTransactionStrategyImpl(
                fruitHandlerMap
        );

        FruitTransaction fruitTransaction = new FruitTransaction(
                fruitsTransactionStrategy, FILE_TO_READ_PATH, FILE_TO_WRITE_PATH
        );
        fruitTransaction.handleTransactions();
        fruitTransaction.writeReportToFile();
    }
}
