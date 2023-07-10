package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String FROM_THIS_FILE = "input.csv";
    private static final String TO_THIS_FILE = "result.csv";

    public static void main(String[] args) {
        ReaderServiceImpl reader = new ReaderServiceImpl();
        List<FruitTransaction> transactions = reader.readFromFile(FROM_THIS_FILE);

        FruitStorage fruitStorage = new FruitStorage();
        FruitService fruitService = new FruitServiceImpl(fruitStorage);
        fruitService.processTransactions(transactions);

        for (FruitTransaction transaction : transactions) {
            fruitStorage.updateFruitQuantity(transaction.getFruit(), transaction.getQuantity());
        }

        List<String> reportData = fruitService.generateReport();

        WriterServiceImpl writer = new WriterServiceImpl();
        writer.writeToFile(TO_THIS_FILE, reportData);
    }
}
