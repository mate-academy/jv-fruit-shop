package service.impl;

import db.FruitStorage;
import java.util.ArrayList;
import java.util.List;
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
        List<String> reportList = new ArrayList<>();
        for (String fruit : fruitSet) {
            int amount = FruitStorage.fruitStore.stream()
                    .filter(fs -> fs.getFruit().equals(fruit))
                    .mapToInt(fs -> storeOperationStrategy.getOperation(fs.getStoreOperation())
                            .getAmount(fs.getQuantity()))
                    .sum();
            if (amount < 0) {
                throw new RuntimeException("Data base contains invalid amount");
            }
            reportList.add(fruit + "," + amount);
        }
        return reportList.stream()
                .collect(Collectors.joining("\n", "fruit,quantity\n", ""));
    }
}
