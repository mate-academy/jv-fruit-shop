package core.basesyntax.data;

import core.basesyntax.transaction.FruitTransaction;

public interface Formater {
    FruitTransaction parseTransaction(String s);
}
