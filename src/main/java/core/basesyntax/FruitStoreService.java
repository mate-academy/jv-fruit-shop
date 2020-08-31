package core.basesyntax;

import core.basesyntax.identities.Storage;
import core.basesyntax.maketransaction.FruitOperation;
import core.basesyntax.maketransaction.Transaction;
import core.basesyntax.maketransaction.operations.BuyOperation;
import core.basesyntax.maketransaction.operations.ReturnOperation;
import core.basesyntax.maketransaction.operations.SupplyOperation;
import core.basesyntax.readwritefile.CsvFileReader;
import core.basesyntax.readwritefile.CsvFileWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStoreService {

    private static Map<String, FruitOperation> transactionMap = new HashMap<>();

    private FruitStoreService() {
        transactionMap.put("s", new SupplyOperation());
        transactionMap.put("b", new BuyOperation());
        transactionMap.put("r", new ReturnOperation());
    }

    public static void terminal(String pathNameFrom, String pathNameTo)
            throws FileNotFoundException {
        new FruitStoreService();
        List<Transaction> transactions = new ArrayList<>(new CsvFileReader().readCsv(pathNameFrom));
        for (Transaction transaction : transactions) {
            transactionMap.get(transaction.getType()).apply(transaction);
        }
        new CsvFileWriter().writeCsv(Storage.currentAmountOfEachTypeOfFruit(), pathNameTo);
    }
}
