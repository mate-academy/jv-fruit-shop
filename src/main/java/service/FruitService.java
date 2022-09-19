package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitService {
    List<FruitTransaction> getReport(List<FruitTransaction> transactions);
}
