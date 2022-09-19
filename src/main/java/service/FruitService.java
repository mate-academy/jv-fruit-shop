package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitService {
    String getReport(List<FruitTransaction> transactions);
}
