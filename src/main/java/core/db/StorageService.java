package core.db;

import java.util.Map;

public interface StorageService<T> {
    Map<String, Integer> addTransaction(T transaction);

    Map<String, Integer> getLeftovers();
}
