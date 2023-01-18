package service.impl;

import db.FruitStorage;
import java.util.Set;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ReportService;
import strategy.StoreOperationStrategy;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport(StoreOperationStrategy storeOperationStrategy) {
        Set<String> fruitSet = FruitStorage.fruitStore.stream()
                .map(FruitTransaction::getFruit)
                .collect(Collectors.toSet());
        return fruitSet.stream()
                .map(ft -> ft + "," + FruitStorage.fruitStore.stream()
                        .filter(fs -> fs.getFruit().equals(ft))
                        .mapToInt(as -> storeOperationStrategy
                                .getOperation(as.getOperation()).getAmount(as.getQuantity()))
                        .sum())
                .collect(Collectors.joining("\n", "fruit,quantity\n", ""));
    }
}
