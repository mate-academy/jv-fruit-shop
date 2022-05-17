package mate.academy.service;

import java.util.List;
import mate.academy.model.FruitTransaction;

public interface ReportService {
    String getReport(List<FruitTransaction> fruitTransactionList);
}
