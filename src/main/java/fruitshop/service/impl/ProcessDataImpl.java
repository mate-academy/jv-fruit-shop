package fruitshop.service.impl;

import fruitshop.db.ReportStorage;
import fruitshop.model.FruitTransaction;
import fruitshop.model.Operation;
import fruitshop.service.data.ProcessDataService;
import fruitshop.strategy.StrategyService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessDataImpl implements ProcessDataService {
    private final Map<String, Integer> balancesOfFruits = new HashMap<>();
    private final ReportStorage reportStorage = new ReportStorage();

    @Override
    public void process(List<FruitTransaction> listOfTransactions,
                        Map<Operation, StrategyService> operationsMap) {
        processOperations(listOfTransactions, operationsMap);
        writeDataToStorage();
    }

    private void processOperations(List<FruitTransaction> listOfTransactions,
                                   Map<Operation, StrategyService> operationsMap) {
        for (FruitTransaction fruitTransaction : listOfTransactions) {
            balancesOfFruits.put(fruitTransaction.getFruit(),
                    operationsMap.get(fruitTransaction.getOperation())
                            .process(fruitTransaction, checkBalance(fruitTransaction.getFruit())));
        }
    }

    private void writeDataToStorage() {
        for (Map.Entry<String, Integer> entry : balancesOfFruits.entrySet()) {
            reportStorage.add(entry.getKey() + "," + entry.getValue());
        }
    }

    private int checkBalance(String key) {
        return balancesOfFruits.getOrDefault(key, 0);
    }
}
