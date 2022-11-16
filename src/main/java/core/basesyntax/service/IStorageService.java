package core.basesyntax.service;

public interface IStorageService {
    boolean transaction(String operation, String fruit, Integer quantity);
}
