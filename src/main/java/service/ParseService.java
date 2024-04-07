package service;

import model.FruitTransaction;

import java.util.List;

public interface ParseService {
    public List<FruitTransaction> parseFromString(List<String> transactions);
}
