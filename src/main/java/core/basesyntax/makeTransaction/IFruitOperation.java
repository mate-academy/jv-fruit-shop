package core.basesyntax.makeTransaction;

import core.basesyntax.identities.Storage;

public interface IFruitOperation {
    boolean apply(Transaction transaction, Storage storage);
}
