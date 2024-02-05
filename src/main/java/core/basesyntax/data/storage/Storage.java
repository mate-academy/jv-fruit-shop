package core.basesyntax.data.storage;

import java.util.List;

public interface Storage<T> {
    List<T> getTransactionHistory();
    List<T> updateTransactionHistory(List<T> newTransactionHistory);
}
