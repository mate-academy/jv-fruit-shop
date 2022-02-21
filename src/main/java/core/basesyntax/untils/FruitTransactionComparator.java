package core.basesyntax.untils;

import core.basesyntax.model.FruitTransaction;
import java.util.Comparator;

public class FruitTransactionComparator implements Comparator<FruitTransaction> {

    @Override
    public int compare(FruitTransaction o1, FruitTransaction o2) {
        if (o1.getOperation().equals(o2.getOperation())) {
            return 0;
        }
        if (o1.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
            return -1;
        }
        if (o2.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
            return 1;
        }
        return 0;
    }
}
