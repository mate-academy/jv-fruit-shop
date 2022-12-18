package service;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public List<String> create(List<FruitTransaction> fruitTransactions,
                               OperationStrategy operationStrategy) {
        List<String> report = new ArrayList<>();
        report.add(REPORT_HEADER);
        Map<String, IntSummaryStatistics> summaryMap = fruitTransactions.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit,
                        Collectors.summarizingInt(fruitTransaction -> operationStrategy
                                .get(fruitTransaction.getOperation())
                                .getValueByOperation(fruitTransaction.getQuantity()))));
        for (Map.Entry<String, IntSummaryStatistics> entry : summaryMap.entrySet()) {
            report.add(entry.getKey() + SEPARATOR + entry.getValue().getSum());
        }
        return report;
    }
}
