package service;

public interface StorageService {
    void add(String fruit, Integer count);

    void set(String fruit, Integer count);

    void subtract(String fruit, Integer count);
}
