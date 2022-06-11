package service;

import java.util.List;
import model.FruitTransaction;

public interface StorageService {

    void add(String fruit, Integer count);

    void set(String fruit, Integer count);

    void subtract(String fruit, Integer count);

    List<String[]> getBalance();

    void fill(List<FruitTransaction> transactions);
}
