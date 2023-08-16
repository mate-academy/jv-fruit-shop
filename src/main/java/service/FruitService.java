package service;

import java.util.List;
import service.impl.FruitServiceImpl;

public interface FruitService {
    void executeTransactions(List<FruitServiceImpl.Transaction> transactions);
}
