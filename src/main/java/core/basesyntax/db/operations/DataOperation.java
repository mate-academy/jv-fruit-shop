package core.basesyntax.db.operations;


import core.basesyntax.model.ItemTransaction;

public interface DataOperation {
    void handle(ItemTransaction transaction);
}
