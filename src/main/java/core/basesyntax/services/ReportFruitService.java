package core.basesyntax.services;

import core.basesyntax.dto.Transaction;
import core.basesyntax.strategy.Operation;
import java.util.List;
import java.util.Map;

public interface ReportFruitService {
    String getReport();

    String createReport(List<String> listData,
                       Map<Transaction.Operation, Operation> operationMap);
}
