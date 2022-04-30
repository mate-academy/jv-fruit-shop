package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ReportService;
import strategy.StrategyService;

public class ReportServiceImpl implements ReportService {
    private static final String SPLIT_SYMBOL = ",";
    private static final String NEXT_LINE = "\n";

    @Override
    public String doReport(List<FruitTransaction> transactions, StrategyService strategyService) {
        Map<String, Integer> reportDataMap = new HashMap<>();
        StringBuilder reportResult = new StringBuilder();
        for (FruitTransaction transaction : transactions) {
            int storeQuantity = reportDataMap.get(transaction.getFruit()) == null ? 0
                    : reportDataMap.get(transaction.getFruit());
            reportDataMap.put(transaction.getFruit(),
                    strategyService.get(transaction.getOperation())
                            .operationHandler(transaction, storeQuantity));
        }
        reportResult.append("fruit,quantity\n");
        for (String e : reportDataMap.keySet()) {
            reportResult.append(e)
                    .append(SPLIT_SYMBOL)
                    .append(reportDataMap.get(e))
                    .append(NEXT_LINE);
        }
        return reportResult.toString().trim();
    }
}
