package core.basesyntax;

import core.basesyntax.identities.Storage;
import core.basesyntax.maketransaction.Transaction;
import core.basesyntax.maketransaction.operations.Buy;
import core.basesyntax.maketransaction.operations.Return;
import core.basesyntax.maketransaction.operations.Supply;
import core.basesyntax.readwritefile.ReadCsv;
import core.basesyntax.readwritefile.WriteCsv;
import java.util.ArrayList;
import java.util.List;

public class FruitStoreService {
    private Storage storage;

    public FruitStoreService() {
        storage = new Storage();
    }

    public void terminal(String pathNameFrom, String pathNameTo) {
        List<Transaction> transactions = new ArrayList<>(new ReadCsv().readCsv(pathNameFrom));
        for (Transaction transaction : transactions) {
            switch (transaction.getType()) {
                case "s":
                    new Supply().apply(transaction, storage);
                    break;
                case "b":
                    new Buy().apply(transaction, storage);
                    break;
                default:
                    new Return().apply(transaction, storage);
                    break;
            }
        }
        new WriteCsv().writeCsv(storage.currentAmountOfEachTypeOfFruit(), pathNameTo);
    }
}
