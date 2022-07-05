package core.db;

import java.util.List;

public interface StorageService<T> {
    List<T> getAll();

    int setAll(List<T> transactions);

    boolean addTransaction(T transaction);
}
