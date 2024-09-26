package core.basesyntax.service;

public interface StorageService {
    void setBalance(String fruit, int quantity);

    void addFruit(String fruit, int quantity);

    void removeFruit(String fruit, int quantity);

}
