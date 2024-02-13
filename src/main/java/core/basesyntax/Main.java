package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParseTransactionService;
import core.basesyntax.service.TransactionReaderService;
import core.basesyntax.service.TransactionWriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParseTransactionServiceImpl;
import core.basesyntax.service.impl.TransactionReaderServiceImpl;
import core.basesyntax.service.impl.TransactionWriterServiceImpl;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

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
    private static ParseTransactionService parseTransactionService =
            new ParseTransactionServiceImpl();

    public static void main(String[] args) {
        List<String> dataFromFile = transactionReaderService.read(INPUT_FILE_NAME);
        List<FruitTransaction> fruitTransactions =
                parseTransactionService.parseTransactions(dataFromFile);
        calculateReport(fruitTransactions);
        transactionWriterService.writeToFile(fruitStorage.getFruitInventory(), REPORT_FILE_NAME);
    }

    private static void calculateReport(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(transaction -> {
            fruitService.calculate(
                    transactionStrategy.getTransactionService(transaction.getOperation().getCode()),
                    transaction,
                    fruitStorage
            );
        });
    }
}
