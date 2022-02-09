package core.basesyntax.service;

public interface StorageService {
    void addToStorage(String aboutProduct);

    Integer getFromStorage(String fruit);

    void setValue(String fruit,Integer setValue);
}
