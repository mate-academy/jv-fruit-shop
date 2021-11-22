package core.db;

public interface StorageService<T, U> {
    void put(T value, U type);
}
