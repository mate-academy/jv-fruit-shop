package service.impl;

import dao.StorageDaoImpl;
import db.Storage;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitsAmountStrategy;
import service.GenerateReportLines;

public class GenerateReportLinesImpl implements GenerateReportLines {
    private static final int INDEX_OF_DESCRIPTION_FIELDS = 0;
    private StorageDaoImpl storageDao;
    private FruitsAmountStrategy fruitsAmountStrategy;

    public GenerateReportLinesImpl(StorageDaoImpl storageDao,
                                   FruitsAmountStrategy fruitsAmountStrategy) {
        this.storageDao = storageDao;
        this.fruitsAmountStrategy = fruitsAmountStrategy;
    }

    @Override
    public void createReportMap(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruit: fruitTransactions) {
            if (Storage.report.containsKey(fruit.getFruit())) {
                int newAmount = Storage.report.get(fruit.getFruit())
                        + fruitsAmountStrategy.get(fruit.getOperation())
                        .getAmount(fruit.getQuantity());
                storageDao.add(fruit.getFruit(),newAmount);
            } else {
                storageDao.add(fruit.getFruit(), fruit.getQuantity());
            }
        }

    }

    @Override
    public List<String> createReport(Map<String, Integer> fruitReport) {

        List<String> report = fruitReport.entrySet().stream()
                .map(m -> String.format("%s, %d", m.getKey(), m.getValue()))
                .collect(Collectors.toList());
        report.add(INDEX_OF_DESCRIPTION_FIELDS,"fruit,quantity");
        return report;
    }
}
