package service;

import java.util.List;
import model.FruitTransaction;

public interface ReportService {
    List<String> create(List<FruitTransaction> fruitTransactions,
                        OperationStrategy operationStrategy);
}
