package fruitshop.service;

import fruitshop.model.FruitReport;
import java.util.List;

public interface TransactionsCalculatorService {
    List<FruitReport> calculate();
}
