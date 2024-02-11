package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.TransactionReaderService;
import core.basesyntax.service.TransactionWriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.TransactionReaderServiceImpl;
import core.basesyntax.service.impl.TransactionWriterServiceImpl;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class Main {
    private static TransactionReaderService transactionReaderService =
            new TransactionReaderServiceImpl();
    private static FruitService fruitService =
            new FruitServiceImpl();
    private static TransactionStrategy transactionStrategy =
            new TransactionStrategy();
    private static FruitStorage fruitStorage =
            new FruitStorage();
    private static TransactionWriterService transactionWriterService =
            new TransactionWriterServiceImpl();

    public static void main(String[] args) {
        List<FruitTransaction> fruitTransactions = transactionReaderService.read();
        int newCount;
        for (FruitTransaction transaction : fruitTransactions) {
            newCount = fruitService.calculate(
                    transactionStrategy.getTransactionService(transaction.getOperation().getCode()),
                    fruitStorage.getFruitInventory().getOrDefault(transaction.getFruit(), 0),
                    transaction.getCount()
            );
            fruitStorage.addFruit(transaction.getFruit(), newCount);
        }
        transactionWriterService.writeToFile(fruitStorage.getFruitInventory());
    }
}
