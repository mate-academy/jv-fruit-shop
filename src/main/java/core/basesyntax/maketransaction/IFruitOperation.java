package core.basesyntax.maketransaction;

import core.basesyntax.identities.Storage;

public interface IFruitOperation {
    boolean apply(Transaction transaction, Storage storage);
}
