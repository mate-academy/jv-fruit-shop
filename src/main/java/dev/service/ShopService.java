package dev.service;

import dev.repository.Repository;
import dev.transaction.FruitTransaction;

import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions, Repository repository);
}
