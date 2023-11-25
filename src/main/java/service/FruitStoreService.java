package service;

import db.FruitStorage;
import java.util.List;
import model.FruitTransaction;

public interface FruitStoreService {
    FruitStorage processTransactions(List<FruitTransaction> transactions);
}
