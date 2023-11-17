package core.basesyntax.handler;

import core.basesyntax.ItemTransaction;
import java.util.List;

public interface Handler {
    void handle(List<ItemTransaction> itemTransactions);
}
