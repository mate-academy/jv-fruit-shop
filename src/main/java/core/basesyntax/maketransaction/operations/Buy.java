package core.basesyntax.maketransaction.operations;

import core.basesyntax.identities.Fruit;
import core.basesyntax.identities.Storage;
import core.basesyntax.maketransaction.IFruitOperation;
import core.basesyntax.maketransaction.Transaction;
import java.time.LocalDate;

public class Buy implements IFruitOperation {
    @Override
    public boolean apply(Transaction transaction, Storage storage) {
        for (int i = 0; i < transaction.getQuantity(); i++) {
            Fruit fruit = new Fruit(transaction.getFruit(), LocalDate.parse(transaction.getDate()));
            storage.removeFruit(fruit);
        }
        return true;
    }
}
