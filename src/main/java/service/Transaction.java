package service;

import java.util.List;
import model.FruitTransaction;

public interface Transaction {
    void process(List<FruitTransaction> data);
}
