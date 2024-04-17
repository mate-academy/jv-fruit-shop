package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.FruitBalance;
import core.basesyntax.strategy.FruitHandler;
import core.basesyntax.strategy.FruitPurchase;
import core.basesyntax.strategy.FruitReturn;
import core.basesyntax.strategy.FruitSupply;
import core.basesyntax.strategy.FruitsTransactionStrategy;
import core.basesyntax.strategy.FruitsTransactionStrategyImpl;
import java.util.List;
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
        List<String[]> transactions = fruitTransaction.getTransactions(FILE_TO_READ_PATH);
        for (int i = 0; i < transactions.size(); i++) {
            String[] transactionValues = transactions.get(i);
            Fruit fruit = fruitTransaction.makeFruit(transactionValues);
            fruitTransaction.handleTransaction(
                    fruit,
                    transactionValues[FruitTransactionServiceImpl.TRANSACTION_TYPE_INDEX]
            );
        }
        String report = fruitTransaction.getReport(Storage.getFruits());
        fruitTransaction.writeReportToFile(FILE_TO_WRITE_PATH, report);
    }
}
