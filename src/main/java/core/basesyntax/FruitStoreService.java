package core.basesyntax;

import core.basesyntax.identities.Storage;
import core.basesyntax.makeTransaction.Transaction;
import core.basesyntax.makeTransaction.operations.Buy;
import core.basesyntax.makeTransaction.operations.Return;
import core.basesyntax.makeTransaction.operations.Supply;
import core.basesyntax.readWriteFile.ReadCSV;
import core.basesyntax.readWriteFile.WriteCSV;

import java.util.ArrayList;
import java.util.List;

public class FruitStoreService {
    private Storage storage;

    public FruitStoreService() {
        storage = new Storage();
    }

    public void terminal(String pathNameFrom, String pathNameTo) {
        List<Transaction> transactions = new ArrayList<>(new ReadCSV().readCSV(pathNameFrom));
        for (Transaction transaction : transactions) {
            switch (transaction.getType()) {
                case "s":
                    new Supply().apply(transaction, storage);
                    break;
                case "b":
                    new Buy().apply(transaction, storage);
                    break;
                case "r":
                    new Return().apply(transaction, storage);
                    break;
            }
        }
        new WriteCSV().writeCSV(storage.currentAmountOfEachTypeOfFruit(), pathNameTo);
    }
}
