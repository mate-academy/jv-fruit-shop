package service;

import java.util.List;
import model.FruitTransaction;

public interface ParseService {
    public List<FruitTransaction> parseFromString(List<String> transactions);
}

