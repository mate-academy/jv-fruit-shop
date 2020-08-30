package core.basesyntax;

import core.basesyntax.identities.Storage;
import core.basesyntax.maketransaction.IFruitOperation;
import core.basesyntax.maketransaction.Transaction;
import core.basesyntax.maketransaction.operations.Buy;
import core.basesyntax.maketransaction.operations.Return;
import core.basesyntax.maketransaction.operations.Supply;
import core.basesyntax.readwritefile.ReadCsv;
import core.basesyntax.readwritefile.WriteCsv;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStoreService {

    private static Map<String, IFruitOperation> transactionMap = new HashMap<>();

    private FruitStoreService() {
        transactionMap.put("s", new Supply());
        transactionMap.put("b", new Buy());
        transactionMap.put("r", new Return());
    }

    public static void terminal(String pathNameFrom, String pathNameTo)
            throws FileNotFoundException {
        new FruitStoreService();
        List<Transaction> transactions = new ArrayList<>(new ReadCsv().readCsv(pathNameFrom));
        for (Transaction transaction : transactions) {
            transactionMap.get(transaction.getType()).apply(transaction);
        }
        new WriteCsv().writeCsv(Storage.currentAmountOfEachTypeOfFruit(), pathNameTo);
    }
}
