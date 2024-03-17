package service;

import model.FruitTransaction;

public interface ParseService {
    public FruitTransaction parseFromString(String transactionStr);
}
