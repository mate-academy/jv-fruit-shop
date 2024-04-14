package core.basesyntax;

import core.basesyntax.strategy.FruitBalance;
import core.basesyntax.strategy.FruitHandler;
import core.basesyntax.strategy.FruitPurchase;
import core.basesyntax.strategy.FruitReturn;
import core.basesyntax.strategy.FruitSupply;
import core.basesyntax.strategy.FruitsTransactionStrategy;
import core.basesyntax.strategy.FruitsTransactionStrategyImpl;
import java.util.Map;

public class Main {
    private static final String FILE_TO_READ_PATH = "src/main/resources/file.csv";
    private static final String FILE_TO_WRITE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, FruitHandler> fruitHandlerMap = Map.of(
                FruitTransactionServiceImpl.Operation.BALANCE.getCode(), new FruitBalance(),
                FruitTransactionServiceImpl.Operation.PURCHASE.getCode(), new FruitPurchase(),
                FruitTransactionServiceImpl.Operation.SUPPLY.getCode(), new FruitSupply(),
                FruitTransactionServiceImpl.Operation.RETURN.getCode(), new FruitReturn()
        );

        FruitsTransactionStrategy fruitsTransactionStrategy = new FruitsTransactionStrategyImpl(
                fruitHandlerMap
        );

        FruitTransactionServiceImpl fruitTransaction = new FruitTransactionServiceImpl(
                fruitsTransactionStrategy
        );
        fruitTransaction.handleTransactions(FILE_TO_READ_PATH);
        fruitTransaction.writeReportToFile(FILE_TO_WRITE_PATH);
    }
}
