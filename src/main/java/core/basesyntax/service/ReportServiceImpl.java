package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationTransaction;
import core.basesyntax.strategy.StorageTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private final StorageTransaction storageTransaction = new StorageTransaction();

    @Override
    public String report(List<String> list) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity" + System.lineSeparator());

        for (String line : list) {
            String[] part = line.trim().split(",");
            OperationTransaction operationTransaction = storageTransaction
                    .getTransactions()
                    .getOrDefault(part[0], null);
            if (operationTransaction != null) {
                operationTransaction.operation(part[1], Integer.parseInt(part[2]));
            }
        }

        String collect = Storage.fruitMap.entrySet()
                .stream()
                .map(i -> i.getKey() + "," + i.getValue())
                .collect(Collectors.joining(System.lineSeparator()));

        return report.append(collect).toString();
    }
}
