package core.service;

import core.db.FruitTransaction;
import java.util.List;

public interface FruitService {
    String getBalanceReport(List<FruitTransaction> transactions);
}
