package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitsAmountStrategy;
import service.GenerateReport;

public class GenerateReportImpl implements GenerateReport {
    private FruitsAmountStrategy fruitsAmountStrategy;

    public GenerateReportImpl(FruitsAmountStrategy fruitsAmountStrategy) {
        this.fruitsAmountStrategy = fruitsAmountStrategy;
    }

    @Override
    public Map<String, Integer> reportMap(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> report = new HashMap<>();
        for (FruitTransaction fruit: fruitTransactions) {
            if (report.containsKey(fruit.getFruit())) {
                int newAmount = fruitsAmountStrategy.get(fruit.getOperation())
                        .getAmount(fruit.getQuantity(), report.get(fruit.getFruit()));
                report.put(fruit.getFruit(),newAmount);
            } else {
                report.put(fruit.getFruit(), fruit.getQuantity());
            }
        }
        return report;
    }

    @Override
    public List<String> createReport(Map<String, Integer> fruitReport) {

        List<String> report = fruitReport.entrySet().stream()
                .map(m -> String.format("%s, %d", m.getKey(), m.getValue()))
                .collect(Collectors.toList());
        report.add(0,"fruit,quantity");
        return report;
    }
}
